package com.example.associationwords.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.associationwords.data.WordsApiRepo
import com.example.associationwords.model.Result
import com.example.associationwords.model.User
import com.example.needmoreassociations.data.UserFirestoreRepo
import com.example.associationwords.data.WordsFirestoreRepo
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class SharedViewModel(
    private val userFirestoreRepo: UserFirestoreRepo,
    private val wordsFirestoreRepo: WordsFirestoreRepo,
    private val wordsApiRepo: WordsApiRepo
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
            when (val result = userFirestoreRepo.checkUserInFirestore(user)) {
                is Result.Success -> {
                    val newUser = User(
                        user.uid,
                        user.displayName!!,
                        user.email!!,
                        user.photoUrl.toString()
                    )

                    if (!result.data) {
                        userFirestoreRepo.createUserInFirestore(newUser)
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

    val someTestFun = liveData(Dispatchers.IO) {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://wordsapiv1.p.rapidapi.com/words/example")
            .get()
            .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "0e7c75cf74msh6000360a7d46376p1f5eabjsnfa5d1835e92d")
            .build()

        val response: Response = client.newCall(request).execute()
        Log.i(TAG, response.toString())


        when (val temp = wordsApiRepo.getWordExample("example")) {
            is Result.Success -> Log.i(TAG, temp.data.examples.toString())
            is Result.Error -> Log.i(TAG, temp.exception.toString())
            is Result.Canceled -> Log.i(TAG, temp.exception.toString())
        }






        emit("Ls")
    }


}