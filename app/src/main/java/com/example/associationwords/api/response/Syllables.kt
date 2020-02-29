package com.example.associationwords.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Syllables( //Слоги

    @Json(name = "count")
    val count: Int,

    @Json(name = "list")
    val syllables: List<String>
)