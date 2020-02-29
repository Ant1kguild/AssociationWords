package com.example.associationwords.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.associationwords.model.Result
import com.example.associationwords.model.User
import com.example.needmoreassociations.data.UserRepository
import com.example.needmoreassociations.data.WordsRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class SharedViewModel(
    private val userRepository: UserRepository,
    private val wordsRepository: WordsRepository
) :
    ViewModel() {

    companion object {
        private const val TAG = "SharedViewModel"
    }

    //LiveData
    private val _authUser = MutableLiveData<FirebaseUser>()
    val authUser: LiveData<FirebaseUser> = _authUser

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _test = MutableLiveData<String>()
    val test: LiveData<String> = _test


    fun checkOrAddUserInFirebase(user: FirebaseUser) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = userRepository.checkUserInFirestore(user)) {
                is Result.Success -> {
                    val newUser = User(
                        user.uid,
                        user.displayName!!,
                        user.email!!,
                        user.photoUrl.toString()
                    )

                    if (!result.data) {
                        userRepository.createUserInFirestore(newUser)
                        Log.i(TAG, "User exist: ${result.data}")
                    } else {
                        Log.i(TAG, "User exist: ${result.data}")
                    }

                    _authUser.postValue(user)
                    _user.postValue(newUser)
                }
                is Result.Error -> TODO()
                is Result.Canceled -> TODO()
            }
        }
    }

    val someTestFun  = liveData(Dispatchers.IO) {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://wordsapiv1.p.rapidapi.com/words/%7Bword%7D/examples")
            .get()
            .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "0e7c75cf74msh6000360a7d46376p1f5eabjsnfa5d1835e92d")
            .build()
        val response: Response = client.newCall(request).execute()
        Log.i(TAG, request.toString())



        emit("Ls")
    }


}