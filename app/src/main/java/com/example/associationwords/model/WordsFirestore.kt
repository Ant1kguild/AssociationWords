package com.example.associationwords.model

data class WordsFirestore(
    val word: String = "",
    val associations : List<String> = listOf()
) {
}