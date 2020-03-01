package com.example.associationwords.data

import com.example.associationwords.api.ResponseHandler
import com.example.associationwords.api.WordsApi
import com.example.associationwords.api.response.WordExample
import com.example.associationwords.api.response.WordInfo
import com.example.associationwords.model.Result
import java.lang.Exception

interface WordsApiRepo {
    suspend fun getWordInfo(word: String): Result<WordInfo>
    suspend fun getWordExample(word: String): Result<WordExample>
}

class WordsApiRepoImpl(private val api: WordsApi, private val responseHandler: ResponseHandler) : WordsApiRepo {

    override suspend fun getWordInfo(word: String): Result<WordInfo> {
        return try {
            responseHandler.handleSuccess(api.getAllWordInfo(word))
        }catch (e : Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun getWordExample(word: String): Result<WordExample> {
        return try {
            responseHandler.handleSuccess(api.getWordExample(word))
        }catch (e : Exception) {
            responseHandler.handleException(e)
        }
    }

}