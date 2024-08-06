package com.madeit.oldbookstore.model

class ModelUsersData {
    var phoneNumber: String? = null
    var name: String? = null
    var email: String? = null
    var city: String? = null
    var point: String? = null
    var userID: String? = null
    var imageUri: String? = null

    constructor()

    constructor(
        phoneNumber: String?, name: String?, email: String?, city: String?,
        point: String?, userID: String?, imageUri: String?
    ) {
        this.phoneNumber = phoneNumber
        this.name = name
        this.email = email
        this.city = city
        this.point = point
        this.userID = userID
        this.imageUri = imageUri
    }

//    fun getImageUri(): String? {
//        return imageUri
//    }
//
//    fun setImageUri(imageUri: String?) {
//        this.imageUri = imageUri
//    }
//
//    fun getPoint(): String? {
//        return point
//    }
//
//    fun setPoint(point: String?) {
//        this.point = point
//    }
//
//    fun getUserID(): String? {
//        return userID
//    }
//
//    fun setUserID(userID: String?) {
//        this.userID = userID
//    }
//
//    fun getPhoneNumber(): String? {
//        return phoneNumber
//    }
//
//    fun setPhoneNumber(phoneNumber: String?) {
//        this.phoneNumber = phoneNumber
//    }
//
//    fun getName(): String? {
//        return name
//    }
//
//    fun setName(name: String?) {
//        this.name = name
//    }
//
//    fun getEmail(): String? {
//        return email
//    }
//
//    fun setEmail(email: String?) {
//        this.email = email
//    }
//
//    fun getCity(): String? {
//        return city
//    }
//
//    fun setCity(city: String?) {
//        this.city = city
//    }
}