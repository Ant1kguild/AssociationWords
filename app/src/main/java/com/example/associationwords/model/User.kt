package com.example.associationwords.model

data class User(
    val uuid: String = "",
    val name: String = "",
    val mail: String= "",
    val photoUrl: String = ""
)

enum class UserValue(val value: String) {
    UUID("uuid"),
    NAME("name"),
    MAIL("mail"),
    PHOTO_URL("photoUrl")
}