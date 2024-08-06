package com.madeit.oldbookstore.firebase

import android.app.Activity
import android.content.Intent
import android.support.annotation.NonNull
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.*
import com.madeit.oldbookstore.activity.DashboardActivity
import com.madeit.oldbookstore.model.ModelUsersData

class GoogleAuthentication(
    private val firebaseAuth: FirebaseAuth,
    private val authStateListener: FirebaseAuth.AuthStateListener,
    private val activity: Activity,
    val mSignInClient: GoogleSignInClient
) {
    private val TAG = "GoogleAuthentication"
    private var idToken: String? = null
    private val database: DatabaseReference =
        FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/").reference
    private val databaseReference: DatabaseReference = database.child("Users")
    private val blockedDatabaseReference: DatabaseReference = database.child("Blocked")
    private val blockeduserList = ArrayList<ModelUsersData>()

    init {
        blockedDatabaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(@NonNull snapshot: DataSnapshot) {
                blockeduserList.clear()
                for (dataSnapshot in snapshot.children) {
                    val blockedUsers = dataSnapshot.getValue(ModelUsersData::class.java)
                    blockedUsers?.let { blockeduserList.add(it) }
                }
                Log.d(TAG, "Blocked users list updated: $blockeduserList")
            }

            override fun onCancelled(@NonNull error: DatabaseError) {
                Log.w(TAG, "Error loading blocked users", error.toException())
            }
        })
    }

    fun signInWithGoogle() {
        val signInIntent = mSignInClient.signInIntent
        activity.startActivityForResult(signInIntent, RC_SIGN_IN)
        Log.d(TAG, "Google Sign-In Intent started")
    }

    fun handleSignInResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d(TAG, "Handling sign-in result")
        Log.d(TAG, "Request Code: $requestCode")
        Log.d(TAG, "Result Code: $resultCode")
        Log.d(TAG, "Expected Request Code (RC_SIGN_IN): $RC_SIGN_IN")

        if (requestCode == RC_SIGN_IN) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                Log.d(TAG, "Sign-in successful")
                Log.d(TAG, "Account: $account")

                if (account != null) {
                    idToken = account.idToken
                    Log.d(TAG, "ID Token: $idToken")

                    val credential = GoogleAuthProvider.getCredential(idToken, null)
                    firebaseAuthWithGoogle(credential)
                } else {
                    Log.w(TAG, "Sign-in result account is null")
                }
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign-in failed", e)
                Log.d(TAG, "Status Code: ${e.statusCode}")
                Log.d(TAG, "Status Message: ${e.message}")
            }
        } else {
            Log.w(TAG, "Request code does not match RC_SIGN_IN")
        }
    }

    private fun firebaseAuthWithGoogle(credential: AuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    if (user != null) {
                        val uid = user.uid
                        val email = user.email
                        val name = user.displayName
                        val imageUrl = user.photoUrl.toString()
                        val model = ModelUsersData(
                            phoneNumber = "",
                            name = name ?: "",
                            email = email ?: "",
                            city = "",
                            point = "",
                            userID = uid,
                            imageUri = imageUrl
                        )
                        databaseReference.child(uid).setValue(model)
                        Log.d(TAG, "User added to database: $model")
                        val intent = Intent(activity, DashboardActivity::class.java)
                        activity.startActivity(intent)
                    } else {
                        Log.w(TAG, "Current user is null after sign-in")
                    }
                } else {
                    Log.w(TAG, "SignInWithCredential:failure", task.exception)
                    Toast.makeText(activity, "Authentication Failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun onStart() {
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    fun onStop() {
        firebaseAuth.removeAuthStateListener(authStateListener)
    }

    companion object {
        private const val RC_SIGN_IN = 9001
    }
}
