package com.example.associationwords.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.needmoreassociations.data.UserRepository
import com.example.needmoreassociations.data.WordsRepository
import com.google.firebase.auth.FirebaseUser

class SharedViewModel(
    userRepository: UserRepository,
    wordsRepository: WordsRepository
) :
    ViewModel() {

    //LiveData
    private val _authUser = MutableLiveData<FirebaseUser>()
    val authUser: LiveData<FirebaseUser> = _authUser


    fun setFirebaseUser(user: FirebaseUser) {_authUser.value = user}
}