package com.madeit.oldbookstore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.firebase.GoogleAuthentication

class MainActivity : AppCompatActivity() {

    private lateinit var phoneNumber: Button
    private lateinit var googleSignIn: Button
    private lateinit var admin: Button
    private lateinit var progressCircular: CircularProgressIndicator
    private lateinit var googleAuthentication: GoogleAuthentication

    companion object {
        private const val RC_SIGN_IN = 9001
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize FirebaseAuth and GoogleSignInClient
        val firebaseAuth = FirebaseAuth.getInstance()
        val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.uid)
            } else {
                Log.d(TAG, "onAuthStateChanged:signed_out")
            }
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("YOUR_SERVER_CLIENT_ID")
            .requestEmail()
            .build()
        val mSignInClient = GoogleSignIn.getClient(this, gso)

        googleAuthentication = GoogleAuthentication(firebaseAuth, authStateListener, this, mSignInClient)

        phoneNumber = findViewById(R.id.phoneNumber_button)
        progressCircular = findViewById(R.id.progress_circular_main)
        googleSignIn = findViewById(R.id.google_button)
        admin = findViewById(R.id.admin_button)

        progressCircular.visibility = View.VISIBLE
        Handler().postDelayed({
            progressCircular.visibility = View.GONE
        }, 3000)

        googleSignIn.setOnClickListener {
            googleAuthentication.signInWithGoogle()
        }

        phoneNumber.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        admin.setOnClickListener {
            startActivity(Intent(this@MainActivity, AdminLogin::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            googleAuthentication.handleSignInResult(requestCode, resultCode, data)
        }
    }

    override fun onStart() {
        super.onStart()
        googleAuthentication.onStart()
    }

    override fun onStop() {
        super.onStop()
        googleAuthentication.onStop()
    }
}