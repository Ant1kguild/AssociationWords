package com.example.associationwords.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pronunciation( //Произношение

    @Json(name = "all")
    val all: String
)