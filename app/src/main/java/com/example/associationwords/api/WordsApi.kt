package com.example.associationwords.api

import com.example.associationwords.model.Result
import com.example.associationwords.api.response.WordExample
import com.example.associationwords.api.response.WordInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface WordsApi {
    @GET("{word}")
    suspend fun getAllWordInfo(@Path("word") word: String) : WordInfo

    @GET("{word}/examples")
    suspend fun getWordExample(@Path("word") word: String) : WordExample
}