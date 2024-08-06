package com.madeit.oldbookstore.activity

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.model.ModelFree
import java.io.IOException
import java.util.UUID

class FreeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var database: DatabaseReference
    private lateinit var main_free: LinearLayout
    private lateinit var front_free: LinearLayout
    private lateinit var back_free: LinearLayout
    private lateinit var bt_free_publish: Button
    private lateinit var edt_book_title: EditText
    private lateinit var edt_description: EditText
    private lateinit var spinner: Spinner
    private lateinit var imageViewMain: ImageView
    private lateinit var imageViewBack: ImageView
    private lateinit var imageViewFront: ImageView

    private var filePathMain: Uri? = null
    private var filePathFront: Uri? = null
    private var filePathBack: Uri? = null
    private var location: String = ""
    private var array: Array<String>? = null
    private var imageUriMain: String? = null
    private var imageUriBack: String? = null
    private var imageUriFront: String? = null
    private var category: String = ""

    private val PICK_IMAGE_REQUEST_MAIN = 22
    private val PICK_IMAGE_REQUEST_FRONT = 23
    private val PICK_IMAGE_REQUEST_BACK = 24

    private lateinit var storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free)

        imageViewMain = findViewById(R.id.image_main_free)
        imageViewBack = findViewById(R.id.image_back_free)
        imageViewFront = findViewById(R.id.image_front_free)
        storageReference = FirebaseStorage.getInstance("gs://old-book-store-144a2.appspot.com").reference
        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Free")
        edt_book_title = findViewById(R.id.edt_book_title_free)
        edt_description = findViewById(R.id.edt_description_free)
        main_free = findViewById(R.id.main_free)
        front_free = findViewById(R.id.front_free)
        back_free = findViewById(R.id.back_free)
        spinner = findViewById(R.id.edt_location_free)
        bt_free_publish = findViewById(R.id.publish_free)
        array = resources.getStringArray(R.array.locations)
        category = intent.getStringExtra("category") ?: ""

        spinner.onItemSelectedListener = this
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, array!!)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aa

        main_free.setOnClickListener {
            SelectImageMain()
        }

        front_free.setOnClickListener {
            SelectImageFront()
        }

        back_free.setOnClickListener {
            SelectImageBack()
        }

        bt_free_publish.setOnClickListener {
            uploadImageFront()
        }
    }

    private fun SelectImageMain() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST_MAIN)
    }

    private fun SelectImageFront() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST_FRONT)
    }

    private fun SelectImageBack() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST_BACK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST_MAIN && resultCode == RESULT_OK && data != null && data.data != null) {
            filePathMain = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePathMain)
                imageViewMain.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST_FRONT && resultCode == RESULT_OK && data != null && data.data != null) {
            filePathFront = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePathFront)
                imageViewFront.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST_BACK && resultCode == RESULT_OK && data != null && data.data != null) {
            filePathBack = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePathBack)
                imageViewBack.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImageMain() {
        filePathMain?.let { filePath ->
            val progressDialog = ProgressDialog(this@FreeActivity)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(filePath)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUriMain = uri.toString()
                        addToFirebase(edt_book_title.text.toString(), edt_description.text.toString(), location, FirebaseAuth.getInstance().currentUser?.uid ?: "", category, imageUriMain, imageUriFront, imageUriBack)
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this@FreeActivity, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@FreeActivity, "Failed " + e.message, Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressDialog.setMessage("Uploading.... ")
                }
                .addOnCompleteListener {
                    val intent = Intent(this@FreeActivity, DashboardActivity::class.java)
                    Toast.makeText(applicationContext, "Main Image Uploaded", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    finish()
                }
        }
    }

    private fun uploadImageFront() {
        filePathFront?.let { filePath ->
            val progressDialog = ProgressDialog(this@FreeActivity)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(filePath)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUriFront = uri.toString()
                        uploadImageBack()
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this@FreeActivity, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@FreeActivity, "Failed " + e.message, Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressDialog.setMessage("Uploading.... ")
                }
        } ?: run {
            uploadImageBack()
        }
    }

    private fun uploadImageBack() {
        filePathBack?.let { filePath ->
            val progressDialog = ProgressDialog(this@FreeActivity)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(filePath)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUriBack = uri.toString()
                        uploadImageMain()
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this@FreeActivity, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@FreeActivity, "Failed " + e.message, Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressDialog.setMessage("Uploading.... ")
                }
        } ?: run {
            uploadImageMain()
        }
    }

    private fun addToFirebase(book_title: String, description: String, location: String, userID: String, category: String, imageUriMain: String?, imageUriFront: String?, imageUriBack: String?) {
        val modelFree = ModelFree(book_title, description, location, userID, category, imageUriMain, imageUriFront, imageUriBack)
        database.child(UUID.randomUUID().toString()).setValue(modelFree)
        Log.d("myApp", database.root.toString())
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        location = array?.get(position) ?: ""
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // No action needed
    }
}