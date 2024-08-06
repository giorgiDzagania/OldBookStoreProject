package com.madeit.oldbookstore.activity.ui.profile

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.DashboardActivity
import com.madeit.oldbookstore.databinding.FragmentProfileBinding
import com.madeit.oldbookstore.model.ModelUsersData
import com.squareup.picasso.Picasso
import java.io.IOException
import java.util.UUID


class ProfileFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var spinner: Spinner
    private lateinit var array: Array<String>
    private lateinit var edt_name: EditText
    private lateinit var edt_phoneNumber: EditText
    private lateinit var edt_email: EditText
    private lateinit var btn_submit: Button
    private lateinit var frameLayout: FrameLayout
    private lateinit var profile: ImageView
    private lateinit var database: DatabaseReference
    private lateinit var storageReference: StorageReference
    private var PICK_IMAGE_REQUEST = 22
    private var filePath: Uri? = null
    private var imageUri: String? = null
    private lateinit var point: String
    private var location: String = "None"

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        spinner = binding!!.spinnerLocationProfileFragment
        edt_name = binding!!.profileNameFragment
        edt_email = binding!!.profileEmailFragment
        edt_phoneNumber = binding!!.profilePhoneNumberFragment
        btn_submit = binding!!.btSubmitProfileFragment
        frameLayout = binding!!.frameLayoutImageProfile
        profile = binding!!.profilePicProfile
        storageReference = FirebaseStorage.getInstance("gs://old-book-store-144a2.appspot.com").reference
        array = resources.getStringArray(R.array.locations)
        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    if (dataSnapshot.key == FirebaseAuth.getInstance().currentUser?.uid) {
                        val modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                        modelUsersData?.let {
                            Picasso.get().load(it.imageUri).fit().into(profile)
                            edt_name.setText(it.name)
                            edt_email.setText(it.email)
                            edt_phoneNumber.setText(it.phoneNumber)
                            point = it.point.toString()
                            location = it.city.toString()
                            imageUri = it.imageUri
                        }
                    }
                }
                spinner.onItemSelectedListener = this@ProfileFragment
                val aa = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, array)
                val pos = aa.getPosition(location)
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = aa
                spinner.setSelection(pos)
                aa.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ProfileFragment", "Error fetching profile data: ${error.message}")
            }
        })

        btn_submit.setOnClickListener {
            if (!TextUtils.isEmpty(edt_name.text)) {
                uploadImage()
            }
        }

        frameLayout.setOnClickListener {
            selectImage()
        }

        return root
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        location = array[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        location = "None"
    }

    private fun addToFirebase(phoneNumber: String, name: String, email: String, city: String, point: String, userID: String, imageUri: String?) {
        val modelUsersData = ModelUsersData(phoneNumber, name, email, city, point, userID, imageUri)
        database.child(FirebaseAuth.getInstance().currentUser?.uid ?: "").setValue(modelUsersData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun uploadImage() {
        filePath?.let { file ->
            val progressDialog = ProgressDialog(context)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            val ref = storageReference.child("profiles/${UUID.randomUUID()}")

            ref.putFile(file)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUri = uri.toString()
                        addToFirebase(edt_phoneNumber.text.toString(), edt_name.text.toString(), edt_email.text.toString(), location, point, FirebaseAuth.getInstance().currentUser?.uid ?: "", imageUri)
                    }

                    progressDialog.dismiss()

                    Toast.makeText(context, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(context, "Failed ${e.message}", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                    progressDialog.setMessage("Uploading.... $progress %")
                }
                .addOnCompleteListener {
                    val intent = Intent(context, DashboardActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
        } ?: run {
            addToFirebase(edt_phoneNumber.text.toString(), edt_name.text.toString(), edt_email.text.toString(), location, point, FirebaseAuth.getInstance().currentUser?.uid ?: "", imageUri)
        }
    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, filePath)
                profile.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}