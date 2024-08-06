package com.madeit.oldbookstore.model

class ModelFree {
    var book_title: String? = null
    var description: String? = null
    var location: String? = null
    var userID: String? = null
    var category: String? = null
    var imageUriMain: String? = null
    var imageUriFront: String? = null
    var imageUriBack: String? = null

    constructor()

    constructor(book_title: String?, description: String?, location: String?, userID: String?, category: String?, imageUriMain: String?, imageUriFront: String?, imageUriBack: String?) {
        this.book_title = book_title
        this.description = description
        this.location = location
        this.userID = userID
        this.category = category
        this.imageUriMain = imageUriMain
        this.imageUriFront = imageUriFront
        this.imageUriBack = imageUriBack
    }

//    fun getImageUriMain(): String? {
//        return imageUriMain
//    }
//
//    fun setImageUriMain(imageUriMain: String?) {
//        this.imageUriMain = imageUriMain
//    }
//
//    fun getImageUriFront(): String? {
//        return imageUriFront
//    }
//
//    fun setImageUriFront(imageUriFront: String?) {
//        this.imageUriFront = imageUriFront
//    }
//
//    fun getImageUriBack(): String? {
//        return imageUriBack
//    }
//
//    fun setImageUriBack(imageUriBack: String?) {
//        this.imageUriBack = imageUriBack
//    }
//
//    fun getCategory(): String? {
//        return category
//    }
//
//    fun setCategory(category: String?) {
//        this.category = category
//    }
//
//    fun getBook_title(): String? {
//        return book_title
//    }
//
//    fun setBook_title(book_title: String?) {
//        this.book_title = book_title
//    }
//
//    fun getDescription(): String? {
//        return description
//    }
//
//    fun setDescription(description: String?) {
//        this.description = description
//    }
//
//    fun getLocation(): String? {
//        return location
//    }
//
//    fun setLocation(location: String?) {
//        this.location = location
//    }
//
//    fun getUserID(): String? {
//        return userID
//    }
//
//    fun setUserID(userID: String?) {
//        this.userID = userID
//    }
}
