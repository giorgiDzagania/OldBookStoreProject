package com.madeit.oldbookstore.firebase

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.telephony.PhoneNumberUtils
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.DashboardActivity
import com.madeit.oldbookstore.activity.ProfileActivity
import com.madeit.oldbookstore.model.ModelUsersData
import java.util.concurrent.TimeUnit

class PhoneNumberAuthentication {

    companion object {
        private lateinit var mAuth1: FirebaseAuth
        private lateinit var mAuth: FirebaseAuth
        private lateinit var database: DatabaseReference
        private lateinit var databaseReference: DatabaseReference

        private var verificationId: String? = null
        private var credential: PhoneAuthCredential? = null
        private var number: String? = null
        private var code: String? = null
        private var activity: Activity? = null
        private var modelUsersData: ModelUsersData? = null

        private lateinit var otpText1: EditText
        private lateinit var otpText2: EditText
        private lateinit var otpText3: EditText
        private lateinit var otpText4: EditText
        private lateinit var otpText5: EditText
        private lateinit var otpText6: EditText

        private val mCallBack = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                verificationId = s
            }

            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                val code = phoneAuthCredential.smsCode
                if (code != null) {
                    otpText1.setText(code[0].toString())
                    otpText2.setText(code[1].toString())
                    otpText3.setText(code[2].toString())
                    otpText4.setText(code[3].toString())
                    otpText5.setText(code[4].toString())
                    otpText6.setText(code[5].toString())
                    verifyCode(code)
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(activity?.applicationContext, e.message, Toast.LENGTH_LONG).show()
                Log.d("myApp", e.message ?: "Unknown error")
            }
        }

        fun initialize(activityParam: Activity) {
            database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/").reference
            databaseReference = database.child("Users")
            mAuth1 = FirebaseAuth.getInstance()
            mAuth = FirebaseAuth.getInstance()
            activity = activityParam

            otpText1 = activityParam.findViewById(R.id.otp1)
            otpText2 = activityParam.findViewById(R.id.otp2)
            otpText3 = activityParam.findViewById(R.id.otp3)
            otpText4 = activityParam.findViewById(R.id.otp4)
            otpText5 = activityParam.findViewById(R.id.otp5)
            otpText6 = activityParam.findViewById(R.id.otp6)
        }

        fun verifyCode(code: String) {
            val credential = PhoneAuthProvider.getCredential(verificationId ?: "", code)
            credential?.let { signInWithCredential(it, activity!!) }
        }

        fun signInWithCredential(credential: PhoneAuthCredential, activity: Activity) {
            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var isUserExist = true
                    for (dataSnapshot in snapshot.children) {
                        modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                        if (FirebaseAuth.getInstance().currentUser?.uid == dataSnapshot.key) {
                            isUserExist = false
                            Log.d("myApp", "User found")
                            break
                        }
                    }
                    if (isUserExist) {
                        mAuth1.signInWithCredential(credential)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(activity.applicationContext, "Task is Completed", Toast.LENGTH_SHORT).show()
                                    databaseReference.addValueEventListener(object : ValueEventListener {
                                        override fun onDataChange(snapshot: DataSnapshot) {
                                            var isNewUser = true
                                            for (dataSnapshot in snapshot.children) {
                                                modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                                                if (FirebaseAuth.getInstance().currentUser?.uid == dataSnapshot.key) {
                                                    isNewUser = false
                                                    Log.d("myApp", "User found")
                                                    break
                                                } else {
                                                    modelUsersData = null
                                                }
                                            }
                                            modelUsersData?.let {
                                                if (it.name.isNullOrEmpty() || it.city.isNullOrEmpty() || it.phoneNumber.isNullOrEmpty() || it.imageUri.isNullOrEmpty()) {
                                                    if (isNewUser) {
                                                        Log.d("myApp", "Adding new user")
                                                        AddToFirebase(number!!, "", "", "", "5", FirebaseAuth.getInstance().currentUser!!.uid, "")
                                                    } else {
                                                        val intent = Intent(activity, ProfileActivity::class.java)
                                                        activity.startActivity(intent)
                                                        Toast.makeText(activity.applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                                                    }
                                                } else {
                                                    val intent = Intent(activity, DashboardActivity::class.java)
                                                    activity.startActivity(intent)
                                                    Toast.makeText(activity, "Login successful", Toast.LENGTH_SHORT).show()
                                                }
                                            } ?: AddToFirebase(number!!, "", "", "", "5", FirebaseAuth.getInstance().currentUser!!.uid, "")
                                        }

                                        override fun onCancelled(error: DatabaseError) {}
                                    })
                                } else {
                                    Log.w("PhoneNumber", "signInWithCredential failed: " + task.exception?.message)
                                    Toast.makeText(activity, "Authentication failed.", Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }

        fun sendVerificationCode(number: String) {
            val check = arrayOf(true, true)
            PhoneNumberAuthentication.number = number
            val formattedNumber = formatE164Number("PK", number)
            val options = PhoneAuthOptions.newBuilder(mAuth1)
                .setPhoneNumber(formattedNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(activity!!)
                .setCallbacks(mCallBack)
                .build()
            if (check[1]) {
                databaseReference.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (dataSnapshot in snapshot.children) {
                            modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                            if (modelUsersData?.phoneNumber == number) {
                                check[0] = false
                            }
                        }
                        if (check[0]) {
                            PhoneAuthProvider.verifyPhoneNumber(options)
                        } else {
                            val intent = Intent(activity, DashboardActivity::class.java)
                            activity?.startActivity(intent)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
            }
        }

        fun formatE164Number(countryCode: String, phNum: String): String {
            return if (TextUtils.isEmpty(countryCode)) {
                phNum
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    PhoneNumberUtils.formatNumber(phNum, countryCode).also {
                        Log.d("myApp", it)
                    }
                } else {
                    Log.d("myApp", "error Phone Number Authentication")
                    phNum
                }
            }
        }

        fun AddToFirebase(phoneNumber: String, name: String, email: String, city: String, point: String, userID: String, imageUri: String) {
            val modelUsersData = ModelUsersData(phoneNumber, name, email, city, point, userID, imageUri)
            database.child("Users").child(userID).setValue(modelUsersData)
            Log.d("myApp", database.root.toString())
            val intent = Intent(activity, ProfileActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}