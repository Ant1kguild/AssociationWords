package com.example.associationwords.api

import com.example.associationwords.model.Result
import okhttp3.internal.http2.ErrorCode
import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException

class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Result<T> {
        return Result.Success(data)
    }

    fun <T : Any> handleException(exception: Exception): Result<T> {
        return when (exception) {
            is HttpException -> Result.Error(exception, getErrorMessage(exception.code()))
            is SocketTimeoutException -> Result.Error(
                exception,
                getErrorMessage(ErrorCode.SETTINGS_TIMEOUT.httpCode)
            )
            else -> Result.Error(exception)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCode.SETTINGS_TIMEOUT.httpCode -> "Time out"
            401 -> "Unauthorised"
            402 -> "Payment Required"
            404 -> "Not found"
            408 -> "Time out"
            else -> "Something went wrong"
        }
    }
}
