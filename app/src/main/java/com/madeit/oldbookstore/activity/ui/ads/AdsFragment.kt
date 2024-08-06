package com.madeit.oldbookstore.activity.ui.ads

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.madeit.oldbookstore.ItemClickListener
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.DisplayAdActivity
import com.madeit.oldbookstore.activity.adapter.DonationsAdapter
import com.madeit.oldbookstore.activity.adapter.PaidAdapter
import com.madeit.oldbookstore.databinding.FragmentAdsBinding
import com.madeit.oldbookstore.model.ModelDonations
import com.madeit.oldbookstore.model.ModelFree
import com.madeit.oldbookstore.model.ModelPaid
import com.madeit.oldbookstore.model.ModelPrice

class AdsFragment : Fragment(), ItemClickListener {
    companion object {
        private var category = ""
        private const val TAG = "MainActivity"
    }

    private lateinit var progressCircular: CircularProgressIndicator
    private lateinit var paidRecyclerView: RecyclerView
    private lateinit var databaseReferencePaid: DatabaseReference
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private val paidItemsList = ArrayList<ModelPaid>()
    private val priceItemsList = ArrayList<ModelPrice>()
    private var paidAdapter: PaidAdapter? = null

    private lateinit var freeRecyclerView: RecyclerView
    private lateinit var databaseReferenceDonations: DatabaseReference
    private val donationsItemsList = ArrayList<ModelDonations>()
    private val freeItemsList = ArrayList<ModelFree>()
    private var donationsAdapter: DonationsAdapter? = null

    private var binding: FragmentAdsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdsBinding.inflate(inflater, container, false)
        val root = binding!!.root

        mActivity = requireActivity()
        mContext = requireContext()
        context?.let { FirebaseApp.initializeApp(it) }

        paidRecyclerView = binding!!.paidAdsRecyclerView
        freeRecyclerView = binding!!.freeAdsRecyclerView
        progressCircular = binding!!.progressCircular

        paidRecyclerView.setHasFixedSize(true)
        paidRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        paidRecyclerView.isNestedScrollingEnabled = false

        freeRecyclerView.setHasFixedSize(true)
        freeRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        freeRecyclerView.isNestedScrollingEnabled = false

        setupDatabaseReferences()

        return root
    }

    private fun setupDatabaseReferences() {
        databaseReferencePaid = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference().child("Prices")
        databaseReferencePaid.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                paidItemsList.clear()
                priceItemsList.clear()
                for (dataSnapshot in snapshot.children) {
                    val pricemodel = dataSnapshot.getValue(ModelPrice::class.java)
                    if (pricemodel?.userID == FirebaseAuth.getInstance().currentUser?.uid) {
                        Log.d("myApp", "current USER: ${FirebaseAuth.getInstance().currentUser?.uid}")
                        val modelPaid = ModelPaid(pricemodel?.imageUriMain, pricemodel?.book_title, pricemodel?.price)
                        paidItemsList.add(modelPaid)
                        if (pricemodel != null) {
                            priceItemsList.add(pricemodel)
                        }
                    }
                }
                paidAdapter = PaidAdapter(mContext, mActivity, paidItemsList as ArrayList<ModelPaid>)
                paidRecyclerView.adapter = paidAdapter
                paidAdapter?.setClickListener(this@AdsFragment)
                paidAdapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })

        databaseReferenceDonations = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference().child("Free")
        databaseReferenceDonations.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                donationsItemsList.clear()
                freeItemsList.clear()
                for (dataSnapshot in snapshot.children) {
                    val freemodel = dataSnapshot.getValue(ModelFree::class.java)
                    if (freemodel?.userID == FirebaseAuth.getInstance().currentUser?.uid) {
                        val modelDonations = ModelDonations(freemodel?.imageUriMain, freemodel?.book_title)
                        donationsItemsList.add(modelDonations)
                        if (freemodel != null) {
                            freeItemsList.add(freemodel)
                        }
                    }
                }
                donationsAdapter = DonationsAdapter(mContext, mActivity, donationsItemsList as ArrayList<ModelDonations>)
                freeRecyclerView.adapter = donationsAdapter
                donationsAdapter?.setClickListener(this@AdsFragment)
                donationsAdapter?.notifyDataSetChanged()
                progressCircular.visibility = View.GONE
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClickPaid(view: View, position: Int) {
        val modelPrice = priceItemsList[position]
        val layoutInflater = LayoutInflater.from(activity)
        val promptView = layoutInflater.inflate(R.layout.prompt_ads, null)

        val alertD = AlertDialog.Builder(requireActivity()).create()

        val delete = promptView.findViewById<Button>(R.id.delete_ads)
        val cancel = promptView.findViewById<Button>(R.id.cancel_ads)
        val viewProfile = promptView.findViewById<Button>(R.id.view_ads)

        delete.setOnClickListener {
            databaseReferencePaid.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {
                        val modelPrice1 = dataSnapshot.getValue(ModelPrice::class.java)
                        if (modelPrice.userID == modelPrice1?.userID) {
                            dataSnapshot.ref.removeValue()
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
            Toast.makeText(activity?.applicationContext, "User Deleted", Toast.LENGTH_SHORT).show()
            alertD.dismiss()
        }

        cancel.setOnClickListener {
            alertD.dismiss()
        }

        viewProfile.setOnClickListener {
            val intent = Intent(activity, DisplayAdActivity::class.java).apply {
                putExtra("price", modelPrice.price)
                putExtra("imageUriMain", modelPrice.imageUriMain)
                putExtra("imageUriFront", modelPrice.imageUriFront)
                putExtra("imageUriBack", modelPrice.imageUriBack)
                putExtra("book_title", modelPrice.book_title)
                putExtra("location", modelPrice.location)
                putExtra("category", modelPrice.category)
                putExtra("userID", modelPrice.userID)
                putExtra("description", modelPrice.description)
            }
            alertD.dismiss()
            startActivity(intent)
        }

        alertD.setView(promptView)
        alertD.show()
    }

    override fun onClickFree(view: View, position: Int) {
        val modelFree = freeItemsList[position]
        val layoutInflater = LayoutInflater.from(activity)
        val promptView = layoutInflater.inflate(R.layout.prompt_ads, null)

        val alertD = AlertDialog.Builder(requireActivity()).create()

        val delete = promptView.findViewById<Button>(R.id.delete_ads)
        val cancel = promptView.findViewById<Button>(R.id.cancel_ads)
        val viewProfile = promptView.findViewById<Button>(R.id.view_ads)

        delete.setOnClickListener {
            databaseReferenceDonations.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {
                        val modelfree1 = dataSnapshot.getValue(ModelFree::class.java)
                        if (modelFree.userID == modelfree1?.userID) {
                            dataSnapshot.ref.removeValue()
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
            Toast.makeText(activity?.applicationContext, "User Deleted", Toast.LENGTH_SHORT).show()
            alertD.dismiss()
        }

        cancel.setOnClickListener {
            alertD.dismiss()
        }

        viewProfile.setOnClickListener {
            val intent = Intent(activity, DisplayAdActivity::class.java).apply {
                putExtra("price", "")
                putExtra("imageUriMain", modelFree.imageUriMain)
                putExtra("imageUriFront", modelFree.imageUriFront)
                putExtra("imageUriBack", modelFree.imageUriBack)
                putExtra("book_title", modelFree.book_title)
                putExtra("location", modelFree.location)
                putExtra("category", modelFree.category)
                putExtra("userID", modelFree.userID)
                putExtra("description", modelFree.description)
            }
            alertD.dismiss()
            startActivity(intent)
        }

        alertD.setView(promptView)
        alertD.show()
    }
}