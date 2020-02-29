package com.example.associationwords.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultWord(

    @Json(name = "definition")
    val definition: String,

    @Json(name = "derivation")
    val derivation: List<String>,

    @Json(name = "examples")
    val examples: List<String>,

    @Json(name = "hasTypes")
    val hasTypes: List<String>,

    @Json(name = "partOfSpeech")
    val partOfSpeech: String,

    @Json(name = "synonyms")
    val synonyms: List<String>,

    @Json(name = "typeOf")
    val typeOf: List<String>
)