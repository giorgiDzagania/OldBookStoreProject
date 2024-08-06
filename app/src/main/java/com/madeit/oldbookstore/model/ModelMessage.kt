package com.madeit.oldbookstore.model

class ModelMessage {
    var id: String? = null
    var message: String? = null
    var time: String? = null

    constructor()

    constructor(id: String?, message: String?, time: String?) {
        this.id = id
        this.message = message
        this.time = time
    }

//    fun getTime(): String? {
//        return time
//    }
//
//    fun setTime(time: String?) {
//        this.time = time
//    }
//
//    fun getId(): String? {
//        return id
//    }
//
//    fun setId(id: String?) {
//        this.id = id
//    }
//
//    fun getMessage(): String? {
//        return message
//    }
//
//    fun setMessage(message: String?) {
//        this.message = message
//    }
}