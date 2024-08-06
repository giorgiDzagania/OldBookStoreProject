package com.madeit.oldbookstore.activity.ui.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.NonNull
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.madeit.oldbookstore.ItemClickListener
import com.madeit.oldbookstore.activity.DisplayAdActivity
import com.madeit.oldbookstore.activity.adapter.DonationsAdapter
import com.madeit.oldbookstore.activity.adapter.PaidAdapter
import com.madeit.oldbookstore.databinding.FragmentHomeBinding
import com.madeit.oldbookstore.model.ModelDonations
import com.madeit.oldbookstore.model.ModelFree
import com.madeit.oldbookstore.model.ModelPaid
import com.madeit.oldbookstore.model.ModelPrice
import com.madeit.oldbookstore.model.ModelUsersData
import java.util.Collections

class HomeFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentHomeBinding
//    private var freeItemsListFull: ArrayList<ModelFree> = ArrayList()
//    private var priceItemsListFull: ArrayList<ModelPrice> = ArrayList()
private var category: String = ""
    private val TAG: String = "MainActivity"
    private lateinit var progressCircular: CircularProgressIndicator
    private lateinit var paidRecyclerView: RecyclerView
    private lateinit var databaseReferencePaid: DatabaseReference
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private val AUTOCOMPLETE_REQUEST_CODE = 121
    // private lateinit var modelUsersData: ModelUsersData
    private lateinit var modelUsersDataArrayList: ArrayList<ModelUsersData>
    private lateinit var paidItemsList1: ArrayList<ModelPaid>
    private lateinit var paidItemsList2: ArrayList<ModelPaid>
    private lateinit var paidItemsList3: ArrayList<ModelPaid>
    private lateinit var paidItemsList4: ArrayList<ModelPaid>
    private lateinit var paidItemsList5: ArrayList<ModelPaid>
    private lateinit var paidItemsListFull: ArrayList<ModelPaid>
    //////////////////////////////////////////////////////////////////////////////////////
    private lateinit var priceItemsList1: ArrayList<ModelPrice>
    private lateinit var priceItemsList2: ArrayList<ModelPrice>
    private lateinit var priceItemsList3: ArrayList<ModelPrice>
    private lateinit var priceItemsList4: ArrayList<ModelPrice>
    private lateinit var priceItemsList5: ArrayList<ModelPrice>
    private lateinit var priceItemsListFull: ArrayList<ModelPrice>
///////////////////////////////////////////////////////////////////////////////////////

    private var paidAdapter: PaidAdapter? = null
    private lateinit var freeRecyclerView: RecyclerView
    private lateinit var databaseReferenceDonations: DatabaseReference
    private lateinit var donationsItemsList1: ArrayList<ModelDonations>
    private lateinit var donationsItemsList2: ArrayList<ModelDonations>
    private lateinit var donationsItemsList3: ArrayList<ModelDonations>
    private lateinit var donationsItemsList4: ArrayList<ModelDonations>
    private lateinit var donationsItemsList5: ArrayList<ModelDonations>
    private lateinit var donationsItemsListFull: ArrayList<ModelDonations>
    /////////////////////////////////////////////////////////////////////////////////////
    private lateinit var freeItemsList1: ArrayList<ModelFree>
    private lateinit var freeItemsList2: ArrayList<ModelFree>
    private lateinit var freeItemsList3: ArrayList<ModelFree>
    private lateinit var freeItemsList4: ArrayList<ModelFree>
    private lateinit var freeItemsList5: ArrayList<ModelFree>
    private lateinit var freeItemsListFull: ArrayList<ModelFree>
    ///////////////////////////////////////////////////////////////////////////////////
    private var donationsAdapter: DonationsAdapter? = null
///////////////////////////////////////////////////////////////////////////////////

    private lateinit var databaseReference: DatabaseReference
    private lateinit var point: String

    // ... other member variables

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        // ... other initialization logic

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                modelUsersDataArrayList.clear()
                for (dataSnapshot in snapshot.children) {
                    val modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                    if (modelUsersData != null) {
                        modelUsersDataArrayList.add(modelUsersData)
                    }
                }
                Collections.sort(modelUsersDataArrayList, UserComparator())
                displayPaidAds()
                displayFreeAds()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })

        // ... other event listeners

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Not null check as it's initialized in onCreateView
//        binding = null
    }

    private fun displayPaidAds() {
        databaseReferencePaid.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                paidItemsListFull.clear()
                priceItemsListFull.clear()
                for (dataSnapshot in snapshot.children) {
                    val pricemodel = dataSnapshot.getValue(ModelPrice::class.java)
                    val modelPaid = ModelPaid(pricemodel!!.imageUriMain, pricemodel.book_title, pricemodel.price)
                    val matchingUser = modelUsersDataArrayList.find { it.userID == pricemodel.userID }
                    if (matchingUser != null) {
                        when (matchingUser.point) {
                            "5" -> {
                                paidItemsList1.add(modelPaid)
                                priceItemsList1.add(pricemodel)
                            }
                            "4" -> {
                                // Add to paidItemsList2 and priceItemsList2
                            }
                            // ... handle other point values
                            else -> {
                                // Do something with non-matching users
                            }
                        }
                    }
                }

                // ... update RecyclerView adapters with paidItemsList and priceItemsList
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    private fun displayFreeAds() {
        databaseReferenceDonations.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                donationsItemsList1.clear()
                freeItemsList1.clear()
                donationsItemsList2.clear()
                freeItemsList2.clear()
                donationsItemsList3.clear()
                freeItemsList3.clear()
                donationsItemsList4.clear()
                freeItemsList4.clear()
                donationsItemsList5.clear()
                freeItemsList5.clear()
                donationsItemsListFull.clear()
                freeItemsListFull.clear()

                for (dataSnapshot in snapshot.children) {
                    val freemodel = dataSnapshot.getValue(ModelFree::class.java)
                    val modelDonations = ModelDonations(freemodel!!.imageUriMain.toString(), freemodel.book_title.toString())
                    for (i in modelUsersDataArrayList.indices) {
                        if (modelUsersDataArrayList[i].userID == freemodel.userID) {
                            when (modelUsersDataArrayList[i].point) {
                                "5" -> {
                                    donationsItemsList1.add(modelDonations)
                                    freeItemsList1.add(freemodel)
                                }
                                "4" -> {
                                    donationsItemsList2.add(modelDonations)
                                    freeItemsList2.add(freemodel)
                                }
                                "3" -> {
                                    donationsItemsList3.add(modelDonations)
                                    freeItemsList3.add(freemodel)
                                }
                                "2" -> {
                                    donationsItemsList4.add(modelDonations)
                                    freeItemsList4.add(freemodel)
                                }
                                "1" -> {
                                    donationsItemsList5.add(modelDonations)
                                    freeItemsList5.add(freemodel)
                                }
                            }
                        }
                    }
                }

                donationsItemsListFull.addAll(donationsItemsList1)
                donationsItemsListFull.addAll(donationsItemsList2)
                donationsItemsListFull.addAll(donationsItemsList3)
                donationsItemsListFull.addAll(donationsItemsList4)
                donationsItemsListFull.addAll(donationsItemsList5)

                freeItemsListFull.addAll(freeItemsList1)
                freeItemsListFull.addAll(freeItemsList2)
                freeItemsListFull.addAll(freeItemsList3)
                freeItemsListFull.addAll(freeItemsList4)
                freeItemsListFull.addAll(freeItemsList5)

                donationsAdapter = DonationsAdapter(mContext, mActivity, donationsItemsListFull as ArrayList<ModelDonations>)
                Log.d("myApp", donationsAdapter.toString())

                if (freeRecyclerView.toString().isEmpty()) {
                    // Handle empty RecyclerView case
                } else {
                    freeRecyclerView.adapter = donationsAdapter
                    donationsAdapter!!.setClickListener(this@HomeFragment)
                    donationsAdapter!!.notifyDataSetChanged()
                    progressCircular.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error:" + error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    class UserComparator : Comparator<ModelUsersData> {
        override fun compare(s1: ModelUsersData, s2: ModelUsersData): Int {
            return Integer.parseInt(s1.point) - Integer.parseInt(s2.point)
        }
    }

    override fun onClickPaid(view: View, position: Int) {
        val modelPrice = priceItemsListFull[position]
        Toast.makeText(context, modelPrice.price, Toast.LENGTH_SHORT).show()
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
        startActivity(intent)
    }

    override fun onClickFree(view: View, position: Int) {
        val modelFree = freeItemsListFull[position]
        Toast.makeText(context, "0", Toast.LENGTH_SHORT).show()
        val intent = Intent(activity, DisplayAdActivity::class.java).apply {
            putExtra("price", "0")
            putExtra("imageUriMain", modelFree.imageUriMain)
            putExtra("imageUriFront", modelFree.imageUriFront)
            putExtra("imageUriBack", modelFree.imageUriBack)
            putExtra("book_title", modelFree.book_title)
            putExtra("location", modelFree.location)
            putExtra("category", modelFree.category)
            putExtra("userID", modelFree.userID)
            putExtra("description", modelFree.description)
        }
        startActivity(intent)
    }
}