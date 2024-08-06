package com.madeit.oldbookstore

object UsersDetails {
    private var username: String = ""
    private var password: String = ""
    private var chatWith: String = ""

    fun getUsername(): String {
        return username
    }

    fun setUsername(username: String) {
        UsersDetails.username = username
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        UsersDetails.password = password
    }

    fun getChatWith(): String {
        return chatWith
    }

    fun setChatWith(chatWith: String) {
        UsersDetails.chatWith = chatWith
    }
}