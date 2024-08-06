package com.madeit.oldbookstore.model

class ModelChatPeople {
    var name: String? = null
    var imageUri: String? = null
    var id: String? = null

    constructor()

    constructor(name: String?, imageUri: String?, id: String?) {
        this.name = name
        this.imageUri = imageUri
        this.id = id
    }

//    fun getId(): String? {
//        return id
//    }

//    fun setId(id: String?) {
//        this.id = id
//    }

//    fun getName(): String? {
//        return name
//    }

//    fun setName(name: String?) {
//        this.name = name
//    }
//
//    fun getImageUri(): String? {
//        return imageUri
//    }
//
//    fun setImageUri(imageUri: String?) {
//        this.imageUri = imageUri
//    }
}