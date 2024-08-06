package com.madeit.oldbookstore.model

class ModelDonations {
    var imageUri: String? = null
    var book_title: String? = null

    constructor()

    constructor(imageUri: String?, book_title: String?) {
        this.imageUri = imageUri
        this.book_title = book_title
    }

//    fun getImageUri(): String? {
//        return imageUri
//    }

//    fun setImageUri(imageUri: String?) {
//        this.imageUri = imageUri
//    }

//    fun getBook_title(): String? {
//        return book_title
//    }

//    fun setBook_title(book_title: String?) {
//        this.book_title = book_title
//    }
}