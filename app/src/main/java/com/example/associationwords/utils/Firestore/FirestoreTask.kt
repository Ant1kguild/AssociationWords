package com.example.associationwords.utils.Firestore

import com.example.associationwords.model.Result
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> Task<T>.awaitTask(): Result<T> {
    val task = this
    val exceptionTask = task.exception

    if (task.isComplete) {
        return if (exceptionTask != null) {
            Result.Error(exceptionTask)
        } else {
            if (task.isCanceled) {
                Result.Canceled(CancellationException("Task $this was cancelled normally."))
            } else {
                @Suppress("UNCHECKED_CAST")
                Result.Success(result as T)
            }
        }
    }

    return suspendCancellableCoroutine { continuation ->
        addOnCompleteListener {
            if (exceptionTask != null) {
                continuation.resumeWithException(exceptionTask)
            } else {
                if(task.isCanceled) {
                    continuation.cancel()
                } else {
                    @Suppress("UNCHECKED_CAST")
                    continuation.resume(Result.Success(result as T))
                }
            }
        }
    }
}