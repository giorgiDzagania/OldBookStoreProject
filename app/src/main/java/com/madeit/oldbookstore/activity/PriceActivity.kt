package com.madeit.oldbookstore.activity

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
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
import com.madeit.oldbookstore.model.ModelPrice
import java.util.UUID

class PriceActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var database: DatabaseReference
    private lateinit var mainPrice: LinearLayout
    private lateinit var frontPrice: LinearLayout
    private lateinit var backPrice: LinearLayout
    private lateinit var btPricePublish: Button
    private lateinit var edtPrice: EditText
    private lateinit var edtBookTitle: EditText
    private lateinit var edtDescription: EditText
    private lateinit var spinner: Spinner
    private lateinit var imageViewMain: ImageView
    private lateinit var imageViewBack: ImageView
    private lateinit var imageViewFront: ImageView
    private lateinit var storageReference: StorageReference

    private val PICK_IMAGE_REQUEST_MAIN = 22
    private val PICK_IMAGE_REQUEST_FRONT = 23
    private val PICK_IMAGE_REQUEST_BACK = 24

    private var filePathMain: Uri? = null
    private var filePathFront: Uri? = null
    private var filePathBack: Uri? = null
    private var imageUriMain: String? = null
    private var imageUriBack: String? = null
    private var imageUriFront: String? = null
    private lateinit var location: String
    private lateinit var array: Array<String>
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price)

        imageViewMain = findViewById(R.id.image_main_price)
        imageViewBack = findViewById(R.id.image_back_price)
        imageViewFront = findViewById(R.id.image_front_price)
        storageReference = FirebaseStorage.getInstance("gs://old-book-store-144a2.appspot.com").reference
        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/").reference
        edtPrice = findViewById(R.id.price)
        edtBookTitle = findViewById(R.id.book_title)
        edtDescription = findViewById(R.id.description)
        mainPrice = findViewById(R.id.main_price)
        frontPrice = findViewById(R.id.front_price)
        backPrice = findViewById(R.id.back_price)
        spinner = findViewById(R.id.spinner_location)
        btPricePublish = findViewById(R.id.bt_price_publish)
        array = resources.getStringArray(R.array.locations)
        category = intent.extras?.getString("category") ?: ""

        spinner.onItemSelectedListener = this
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, array)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aa

        mainPrice.setOnClickListener { selectImageMain() }
        frontPrice.setOnClickListener { selectImageFront() }
        backPrice.setOnClickListener { selectImageBack() }

        btPricePublish.setOnClickListener { uploadImageFront() }
    }

    private fun selectImageMain() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST_MAIN)
    }

    private fun selectImageFront() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST_FRONT)
    }

    private fun selectImageBack() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST_BACK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && data != null && data.data != null) {
            val bitmap: Bitmap?
            when (requestCode) {
                PICK_IMAGE_REQUEST_MAIN -> {
                    filePathMain = data.data
                    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePathMain)
                    imageViewMain.setImageBitmap(bitmap)
                }
                PICK_IMAGE_REQUEST_FRONT -> {
                    filePathFront = data.data
                    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePathFront)
                    imageViewFront.setImageBitmap(bitmap)
                }
                PICK_IMAGE_REQUEST_BACK -> {
                    filePathBack = data.data
                    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePathBack)
                    imageViewBack.setImageBitmap(bitmap)
                }
            }
        }
    }

    private fun uploadImageMain() {
        filePathMain?.let {
            val progressDialog = ProgressDialog(this).apply {
                setTitle("Uploading...")
                show()
            }

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(it)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUriMain = uri.toString()
                        Log.d("myApp", imageUriMain!!)
                        addToFirebase(
                            edtPrice.text.toString(),
                            edtBookTitle.text.toString(),
                            edtDescription.text.toString(),
                            location,
                            FirebaseAuth.getInstance().currentUser?.uid ?: "",
                            category,
                            imageUriMain ?: "",
                            imageUriFront ?: "",
                            imageUriBack ?: ""
                        )
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this@PriceActivity, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@PriceActivity, "Failed ${e.message}", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressDialog.setMessage("Uploading.... ")
                }
                .addOnCompleteListener { task ->
                    Intent(this@PriceActivity, DashboardActivity::class.java).also {
                        Toast.makeText(applicationContext, "Main Image Uploaded", Toast.LENGTH_SHORT).show()
                        startActivity(it)
                        finish()
                    }
                }
        }
    }

    private fun uploadImageFront() {
        filePathFront?.let {
            val progressDialog = ProgressDialog(this).apply {
                setTitle("Uploading...")
                show()
            }

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(it)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUriFront = uri.toString()
                        Log.d("myApp", imageUriFront!!)
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this@PriceActivity, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@PriceActivity, "Failed ${e.message}", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressDialog.setMessage("Uploading.... ")
                }
                .addOnCompleteListener {
                    Toast.makeText(applicationContext, "Front Image Uploaded", Toast.LENGTH_SHORT).show()
                    uploadImageBack()
                }
        } ?: uploadImageBack()
    }

    private fun uploadImageBack() {
        filePathBack?.let {
            val progressDialog = ProgressDialog(this).apply {
                setTitle("Uploading...")
                show()
            }

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(it)
                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        imageUriBack = uri.toString()
                        Log.d("myApp", imageUriBack!!)
                    }
                    progressDialog.dismiss()
                    Toast.makeText(this@PriceActivity, "Image Uploaded!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@PriceActivity, "Failed ${e.message}", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressDialog.setMessage("Uploading.... ")
                }
                .addOnCompleteListener {
                    Toast.makeText(applicationContext, "Back Image Saved", Toast.LENGTH_SHORT).show()
                    uploadImageMain()
                }
        } ?: uploadImageMain()
    }

    private fun addToFirebase(price: String, bookTitle: String, description: String, location: String, userID: String, category: String, imageUriMain: String, imageUriFront: String, imageUriBack: String) {
        val modelPrice = ModelPrice(price, bookTitle, description, location, userID, category, imageUriMain, imageUriFront, imageUriBack)
        database.child("Prices").child(UUID.randomUUID().toString()).setValue(modelPrice)
        Log.d("myApp", database.root.toString())
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        location = array[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
    }
}