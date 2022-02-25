package com.magicapp.facebookkotlinui.model
data class Post(
    var profile: Int,
    var profileS: String,
    var fullName: String,
    var photo: Int,
    var photos: ArrayList<String>? = null
)