package com.example.associationwords.api

import com.example.associationwords.BuildConfig


object ApiConstants  {


    const val WORDS_BASE_URL = "https://wordsapiv1.p.rapidapi.com/words/"
    const val WORDS_HEADER_HOST_NAME = "x-rapidapi-host"
    const val WORDS_HEADER_HOST_VALUE = "wordsapiv1.p.rapidapi.com"
    const val WORDS_HEADER_KEY_NAME = "x-rapidapi-key"
    const val WORDS_HEADER_KEY_VALUE = BuildConfig.WORDS_API_KEY

}