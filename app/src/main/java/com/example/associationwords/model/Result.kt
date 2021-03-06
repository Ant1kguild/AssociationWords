package com.example.associationwords.model

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: java.lang.Exception, val exceptionMessage : String = "") : Result<Nothing>()
    data class Canceled(val exception: Exception?) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception], ErrorMessage = $exceptionMessage"
            is Canceled -> "Canceled[exception=$exception]"
        }
    }
}
