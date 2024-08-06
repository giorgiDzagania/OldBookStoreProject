package com.madeit.oldbookstore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.madeit.oldbookstore.R

class AdminLogin : AppCompatActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        editTextUsername = findViewById(R.id.username)
        editTextPassword = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.login)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username == "admin" && password == "admin") {
                val intent = Intent(this@AdminLogin, AdminPanel::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Kindly Input Correct Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}