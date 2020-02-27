package com.example.associationwords.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.associationwords.model.User
import com.example.associationwords.model.Result
import com.example.needmoreassociations.data.UserRepository
import com.example.needmoreassociations.data.WordsRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
}