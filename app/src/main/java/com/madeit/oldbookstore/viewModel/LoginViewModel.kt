package com.madeit.oldbookstore.viewModel

import android.util.Log
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madeit.oldbookstore.firebase.PhoneNumberAuthentication
import com.madeit.oldbookstore.model.ModelLogin


class LoginViewModel : ViewModel() {

    private val _toastMessage = MutableLiveData<String?>()
    val toastMessage: LiveData<String?> get() = _toastMessage

    private val _otpMessage = MutableLiveData<String?>()
    val otpMessage: LiveData<String?> get() = _otpMessage

    private val _backMessage = MutableLiveData<String?>()
    val backMessage: LiveData<String?> get() = _backMessage

    val userPhoneNumber = MutableLiveData<String?>()

    val userOtp_1 = MutableLiveData<String?>()
    val userOtp_2 = MutableLiveData<String?>()
    val userOtp_3 = MutableLiveData<String?>()
    val userOtp_4 = MutableLiveData<String?>()
    val userOtp_5 = MutableLiveData<String?>()
    val userOtp_6 = MutableLiveData<String?>()

    private var modelLogin: ModelLogin = ModelLogin("", "", "", "", "", "", "")

    private val successMessage = "Login Successful"
    private val errorMessage = "Wrong OTP"
    private val successOTPReceived = "OTP Received"
    private val failedOTPReceived = "OTP Not Received"
    private val backMessageSuccess = "Backed"

    private val phoneNumberAuthentication = PhoneNumberAuthentication()

    fun onSubmitButtonClicked() {
        val otp = "${userOtp_1.value}${userOtp_2.value}${userOtp_3.value}${userOtp_4.value}${userOtp_5.value}${userOtp_6.value}"
        if (otp.isEmpty()) {
            _toastMessage.value = null
            Log.d("myApp", "submit button $_toastMessage")
        } else {
            _toastMessage.value = otp
        }
    }

    fun onSendOTPButtonClicked() {
        if (userPhoneNumber.value.isNullOrEmpty()) {
            _otpMessage.value = null
            Log.d("myApp", "otp $_otpMessage")
        } else {
            _otpMessage.value = userPhoneNumber.value
        }
    }

    fun onBackButtonClicked() {
        _backMessage.value = backMessageSuccess
    }

    // Inverse method for two-way binding
    @InverseMethod("stringToPhoneNumber")
    fun phoneNumberToString(phoneNumber: String?): String? {
        return phoneNumber
    }

    fun stringToPhoneNumber(value: String?): String? {
        return value
    }

    @InverseMethod("stringToOtp")
    fun otpToString(otp: String?): String? {
        return otp
    }

    fun stringToOtp(value: String?): String? {
        return value
    }
}