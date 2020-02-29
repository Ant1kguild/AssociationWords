package com.example.associationwords.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiWordsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original : Request = chain.request()
        val request = original.newBuilder()
            .header(ApiConstants.WORDS_HEADER_HOST_NAME, ApiConstants.WORDS_HEADER_HOST_VALUE)
            .header(ApiConstants.WORDS_HEADER_KEY_NAME, ApiConstants.WORDS_HEADER_KEY_VALUE)
            .build()
        return chain.proceed(request)
    }

}