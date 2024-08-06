package com.madeit.oldbookstore.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.databinding.ActivityLoginBinding
import com.madeit.oldbookstore.firebase.PhoneNumberAuthentication
import com.madeit.oldbookstore.model.ModelUsersData
import com.madeit.oldbookstore.viewModel.LoginViewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var usersDetails: ModelUsersData

    companion object {
        var activity: Activity? = null

        @BindingAdapter("toastMessage")
        @JvmStatic
        fun bindToastMessage(view: View, message: String?) {
            message?.let {
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
                Log.d("myApp", message)
                PhoneNumberAuthentication.verifyCode(message)
            }
        }

        @BindingAdapter("otpMessage")
        @JvmStatic
        fun bindOtpMessage(view: View, message: String?) {
            message?.let {
                Log.d("myApp", message)
                PhoneNumberAuthentication.sendVerificationCode(message)
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
            }
        }

        @BindingAdapter("backMessage")
        @JvmStatic
        fun bindBackMessage(view: View, message: String?) {
            message?.let {
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
                (view.context as? Activity)?.finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityLoginBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityLoginBinding.viewmodel = LoginViewModel()
        activityLoginBinding.executePendingBindings()

        PhoneNumberAuthentication.initialize(this)
        database = FirebaseDatabase.getInstance().reference
        usersDetails = ModelUsersData()
        activity = this
    }
}