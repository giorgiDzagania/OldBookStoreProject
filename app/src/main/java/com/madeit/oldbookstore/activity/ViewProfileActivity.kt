package com.madeit.oldbookstore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.madeit.oldbookstore.R
import com.squareup.picasso.Picasso

class ViewProfileActivity : AppCompatActivity() {

    private lateinit var txtName: TextView
    private lateinit var txtPhoneNumber: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtLocation: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val location = intent.getStringExtra("location")
        val image = intent.getStringExtra("image")
        val email = intent.getStringExtra("email")

        txtName = findViewById(R.id.profile_view_name)
        txtEmail = findViewById(R.id.profile_view_email)
        txtLocation = findViewById(R.id.profile_view_location)
        txtPhoneNumber = findViewById(R.id.profile_view_phoneNumber)
        imageView = findViewById(R.id.profilePicViewActivityProfile)

        txtName.text = name
        txtLocation.text = location
        txtEmail.text = email
        txtPhoneNumber.text = phoneNumber
        Picasso.get().load(image).fit().into(imageView)
    }
}