package com.madeit.oldbookstore.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ml.modeldownloader.CustomModelDownloadConditions
import com.google.firebase.ml.modeldownloader.DownloadType
import com.google.firebase.ml.modeldownloader.FirebaseModelDownloader
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.common.model.LocalModel
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.model.ModelMessage
import com.madeit.oldbookstore.model.ModelUsersData
import com.squareup.picasso.Picasso
import org.tensorflow.lite.task.text.nlclassifier.NLClassifier
import java.sql.Timestamp
import java.util.UUID
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DisplayAdActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var mRef_Reports: DatabaseReference
    private lateinit var mRef_Messages: DatabaseReference
    private lateinit var modelUsersData: ModelUsersData

    private var neg = 0.0
    private var pos = 0.0

    private val TAG = "TextClassificationDemo"

    // Executor service for background tasks
    private lateinit var executorService: ExecutorService

    // Text classifier instance
    private lateinit var textClassifier: NLClassifier

    // Variables for UI elements
    private lateinit var price: String
    private lateinit var imageUriMain: String
    private lateinit var imageUriFront: String
    private lateinit var imageUriBack: String
    private lateinit var book_title: String
    private lateinit var location: String
    private lateinit var category: String
    private lateinit var userID: String
    private lateinit var description: String

    private lateinit var imageViewMain: ImageView
    private lateinit var imageViewFront: ImageView
    private lateinit var imageViewBack: ImageView
    private lateinit var txt_price: TextView
    private lateinit var txt_book_title: TextView
    private lateinit var txt_description: TextView
    private lateinit var txt_location: TextView
    private lateinit var txt_category: TextView
    private lateinit var txt_city: TextView
    private lateinit var txt_email: TextView
    private lateinit var txt_name: TextView
    private lateinit var txt_phoneNumber: TextView
    private lateinit var btn_chat: Button
    private lateinit var btn_report: Button
    private lateinit var profile_pic: ImageView
    private lateinit var btn_dial: Button
    private lateinit var edt_feeback: EditText
    private lateinit var btn_submit: Button
    private lateinit var txt_feedback: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_ad)

        executorService = Executors.newSingleThreadExecutor()

        databaseReference = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Users")
        mRef_Reports = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Reports")
        mRef_Messages = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Messages")

        price = intent.getStringExtra("price") ?: ""
        imageUriMain = intent.getStringExtra("imageUriMain") ?: ""
        imageUriFront = intent.getStringExtra("imageUriFront") ?: ""
        imageUriBack = intent.getStringExtra("imageUriBack") ?: ""
        book_title = intent.getStringExtra("book_title") ?: ""
        location = intent.getStringExtra("location") ?: ""
        category = intent.getStringExtra("category") ?: ""
        userID = intent.getStringExtra("userID") ?: ""
        description = intent.getStringExtra("description") ?: ""

        imageViewMain = findViewById(R.id.display_ad_image_main)
        imageViewFront = findViewById(R.id.display_ad_image_front)
        imageViewBack = findViewById(R.id.display_ad_image_back)
        txt_price = findViewById(R.id.display_ad_price)
        txt_book_title = findViewById(R.id.display_ad_book_title)
        txt_description = findViewById(R.id.display_ad_description)
        txt_location = findViewById(R.id.display_ad_location)
        txt_category = findViewById(R.id.display_ad_category)
        txt_city = findViewById(R.id.display_ad_city)
        txt_email = findViewById(R.id.display_ad_email)
        txt_name = findViewById(R.id.display_ad_name)
        txt_phoneNumber = findViewById(R.id.display_ad_phoneNumber)
        btn_chat = findViewById(R.id.chat_display_ad)
        btn_report = findViewById(R.id.report_display_ad)
        profile_pic = findViewById(R.id.profile_pic_display_ad)
        btn_dial = findViewById(R.id.dial_display_ad)
        edt_feeback = findViewById(R.id.feedback_display_ad)
        btn_submit = findViewById(R.id.display_ad_submit_activity)
        txt_feedback = findViewById(R.id.txt_feedback)

        if (userID == FirebaseAuth.getInstance().currentUser?.uid) {
            btn_dial.visibility = View.GONE
            btn_chat.visibility = View.GONE
            btn_report.visibility = View.GONE
            edt_feeback.visibility = View.GONE
            txt_feedback.visibility = View.GONE
            btn_submit.visibility = View.GONE
        }

        if (imageUriMain.isNotEmpty()) {
            Picasso.get().load(imageUriMain).fit().into(imageViewMain)
        }
        if (imageUriFront.isNotEmpty()) {
            Picasso.get().load(imageUriFront).fit().into(imageViewFront)
        }
        if (imageUriBack.isNotEmpty()) {
            Picasso.get().load(imageUriBack).fit().into(imageViewBack)
        }
        txt_price.text = price
        txt_book_title.text = book_title
        txt_description.text = description
        txt_location.text = location
        txt_category.text = category

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    if (userID == dataSnapshot.key) {
                        modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)!!
                        for (childSnapshot in dataSnapshot.children) {
                            when (childSnapshot.key) {
                                "city" -> txt_city.text = childSnapshot.value.toString()
                                "email" -> txt_email.text = childSnapshot.value.toString()
                                "name" -> txt_name.text = childSnapshot.value.toString()
                                "phoneNumber" -> txt_phoneNumber.text = childSnapshot.value.toString()
                                "imageUri" -> Picasso.get().load(childSnapshot.value.toString()).fit().into(profile_pic)
                            }
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })

        btn_chat.setOnClickListener {
            if (mRef_Messages == null) {
                modelUsersData.userID?.let { it1 -> addToMessages(it1, "Chat Initiated") }
            } else {
                mRef_Messages.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.hasChildren()) {
                            mRef_Messages.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(snapshot: DataSnapshot) {
                                    for (dataSnapshot in snapshot.children) {
                                        if (!dataSnapshot.key.equals("${FirebaseAuth.getInstance().currentUser?.uid}_${modelUsersData.userID}")) {
                                            modelUsersData.userID?.let { it1 -> addToMessages(it1, "Chat Initiated") }
                                        } else {
                                            Toast.makeText(applicationContext, "Go to Inbox to chat", Toast.LENGTH_SHORT).show()
                                            break
                                        }
                                    }
                                }

                                override fun onCancelled(error: DatabaseError) {}
                            })
                        } else {
                            modelUsersData.userID?.let { it1 -> addToMessages(it1, "Chat Initiated") }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
            }
        }

        btn_report.setOnClickListener {
            Toast.makeText(applicationContext, "User Reported. Admin will deal with it", Toast.LENGTH_SHORT).show()
            modelUsersData.phoneNumber?.let { it1 ->
                modelUsersData.name?.let { it2 ->
                    modelUsersData.email?.let { it3 ->
                        modelUsersData.city?.let { it4 ->
                            modelUsersData.point?.let { it5 ->
                                modelUsersData.userID?.let { it6 ->
                                    modelUsersData.imageUri?.let { it7 ->
                                        addToReportList(
                                            it1,
                                            it2,
                                            it3,
                                            it4,
                                            it5,
                                            it6,
                                            it7
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        btn_dial.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${modelUsersData.phoneNumber}")
            startActivity(intent)
        }

        btn_submit.setOnClickListener {
            classify(edt_feeback.text.toString())
        }

        downloadModel("sentiment_analysis")
    }

    private fun addToFirebase(phoneNumber: String, name: String, email: String, city: String, point: String, userID: String, imageUri: String) {
        val modelUsersData = ModelUsersData(phoneNumber, name, email, city, point, userID, imageUri)
        databaseReference.child(userID).setValue(modelUsersData)
    }

    private fun addToReportList(phoneNumber: String, name: String, email: String, city: String, point: String, userID: String, imageUri: String) {
        val modelUsersData = ModelUsersData(phoneNumber, name, email, city, point, userID, imageUri)
        mRef_Reports.child(userID).setValue(modelUsersData)
    }

    private fun addToMessages(id: String, message: String) {
        val timestamp = Timestamp(System.currentTimeMillis())
        val modelMessage1 = ModelMessage(id, "To:$message", timestamp.time.toString())
        val modelMessage2 = ModelMessage(FirebaseAuth.getInstance().currentUser?.uid ?: "", "From:$message", timestamp.time.toString())

        if (FirebaseAuth.getInstance().currentUser?.uid != id) {
            mRef_Messages.child("${FirebaseAuth.getInstance().currentUser?.uid}_${id}").child(UUID.randomUUID().toString()).setValue(modelMessage1)
            mRef_Messages.child("$id${FirebaseAuth.getInstance().currentUser?.uid}").child(UUID.randomUUID().toString()).setValue(modelMessage2)

            Toast.makeText(this@DisplayAdActivity, "Chat initiated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "This is your own ad", Toast.LENGTH_SHORT).show()
        }

        val intent = Intent(this@DisplayAdActivity, ChatActivity::class.java)
        intent.putExtra("id", modelUsersData.userID)
        startActivity(intent)
    }

    private fun classify(text: String) {
        executorService.execute {
            val results = textClassifier.classify(text)

            var posFound = false
            var negFound = false

            for (result in results) {
                if (result.label == "Negative") {
                    neg = result.score.toDouble()
                    negFound = true
                }
                if (result.label == "Positive") {
                    pos = result.score.toDouble()
                    posFound = true
                }
            }

            runOnUiThread {
                if (negFound) {
                    Toast.makeText(this@DisplayAdActivity, "Negative", Toast.LENGTH_SHORT).show()
                } else if (posFound) {
                    Toast.makeText(this@DisplayAdActivity, "Positive", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@DisplayAdActivity, "Neutral", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun downloadModel(modelName: String) {
        val conditions = CustomModelDownloadConditions.Builder()
            .requireWifi()
            .build()

        FirebaseModelDownloader.getInstance()
            .getModel(modelName, DownloadType.LOCAL_MODEL, conditions)
            .addOnSuccessListener { model ->
                // Download complete. You can now use the text classifier.
                textClassifier = NLClassifier.createFromFile(model.file)
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                Log.e(TAG, "Failed to download model: $e")
            }
    }
}