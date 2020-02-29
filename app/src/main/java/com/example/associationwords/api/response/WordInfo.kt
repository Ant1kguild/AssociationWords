package com.example.associationwords.api.response

import com.example.associationwords.api.response.Pronunciation
import com.example.associationwords.api.response.ResultWord
import com.example.associationwords.api.response.Syllables
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WordInfo(

    @Json(name = "pronunciation")
    val pronunciation: Pronunciation,

    @Json(name = "results")
    val results: List<ResultWord>,

    @Json(name = "syllables")
    val syllables: Syllables,

    @Json(name = "word")
    val word: String
)