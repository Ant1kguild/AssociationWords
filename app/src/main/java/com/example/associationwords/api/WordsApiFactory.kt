package com.example.associationwords.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object WordsApiFactory {
    private var clietn : OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiWordsInterceptor())
        .build()

    private fun retrofit() : Retrofit = Retrofit.Builder()
        .client(clietn)
        .baseUrl(ApiConstants.WORDS_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val wordsApi : WordsApi = retrofit().create(WordsApi::class.java)
}