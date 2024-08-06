package com.madeit.oldbookstore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.madeit.oldbookstore.R

class AdminPanel : AppCompatActivity() {
    private lateinit var buttonAllUsers: Button
    private lateinit var buttonReportedUsers: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)

        buttonAllUsers = findViewById(R.id.all_users)
        buttonReportedUsers = findViewById(R.id.reported_users)

        buttonReportedUsers.setOnClickListener {
            val intent = Intent(this@AdminPanel, ReportedUsers::class.java)
            startActivity(intent)
        }

        buttonAllUsers.setOnClickListener {
            val intent = Intent(this@AdminPanel, AllUsersActivity::class.java)
            startActivity(intent)
        }
    }
}