package com.example.associationwords.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WordExample(

    @Json(name = "examples")
    val examples: List<String>,

    @Json(name = "word")
    val word: String
)