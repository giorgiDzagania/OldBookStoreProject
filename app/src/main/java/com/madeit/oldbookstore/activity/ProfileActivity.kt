package com.madeit.oldbookstore.activity

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.model.ModelUsersData
import java.io.IOException
import java.util.UUID

class ProfileActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var spinner: Spinner
    private var location: String? = null
    private lateinit var array: Array<String>
    private lateinit var edtName: EditText
    private lateinit var edtPhoneNumber: EditText
    private lateinit var edtEmail: EditText
    private lateinit var btnSubmit: Button
    private lateinit var frameLayout: FrameLayout
    private val PICK_IMAGE_REQUEST = 22
    private var filePath: Uri? = null
    private var imageUri: String? = null
    private lateinit var profile: ImageView
    private lateinit var storageReference: StorageReference
    private lateinit var database: DatabaseReference
    private var point: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        spinner = findViewById(R.id.spinner_location_profile)
        edtName = findViewById(R.id.profile_name)
        edtEmail = findViewById(R.id.profile_email)
        edtPhoneNumber = findViewById(R.id.profile_phoneNumber)
        frameLayout = findViewById(R.id.frameLayout_image_activity_profile)
        profile = findViewById(R.id.profilePicActivityProfile)
        storageReference = FirebaseStorage.getInstance("gs://old-book-store-144a2.appspot.com").reference
        btnSubmit = findViewById(R.id.bt_submit_profile)
        array = resources.getStringArray(R.array.locations)
        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/").reference.child("Users")
        spinner.onItemSelectedListener = this
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, array)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aa

        val progressDialog = ProgressDialog(this).apply {
            setTitle("Loading...")
            show()
        }

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    if (dataSnapshot.key == FirebaseAuth.getInstance().currentUser?.uid) {
                        val modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                        modelUsersData?.let {
                            edtName.setText(it.name)
                            edtEmail.setText(it.email)
                            edtPhoneNumber.setText(it.phoneNumber)
                            point = it.point
                        }
                    }
                }
                progressDialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                progressDialog.dismiss()
            }
        })

        btnSubmit.setOnClickListener {
            if (edtName.text.isNotEmpty()) {
                uploadImage()
            } else {
                Toast.makeText(this, "Name Cannot be Empty", Toast.LENGTH_SHORT).show()
            }
        }

        frameLayout.setOnClickListener {
            selectImage()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        location = array[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        location = "None"
    }

    private fun addToFirebase(phoneNumber: String, name: String, email: String, city: String, point: String?, userID: String, imageUri: String?) {
        val modelUsersData = ModelUsersData(phoneNumber, name, email, city, point, userID, imageUri)
        database.child(FirebaseAuth.getInstance().currentUser?.uid ?: "").setValue(modelUsersData)
        val intent = Intent(this, DashboardActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }

    private fun uploadImage() {
        filePath?.let { uri ->
            val progressDialog = ProgressDialog(this).apply {
                setTitle("Uploading...")
                show()
            }

            val ref = storageReference.child("profiles/" + UUID.randomUUID().toString())
            ref.putFile(uri)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { downloadUri ->
                        imageUri = downloadUri.toString()
                        addToFirebase(edtPhoneNumber.text.toString(), edtName.text.toString(), edtEmail.text.toString(), location ?: "", point, FirebaseAuth.getInstance().currentUser?.uid ?: "", imageUri)
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this, "Failed ${e.message}", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                    progressDialog.setMessage("Uploading.... ")
                }
                .addOnCompleteListener {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
        }
    }

    private fun selectImage() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                profile.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}