package com.example.associationwords.di

import com.example.associationwords.api.ResponseHandler
import com.example.associationwords.api.WordsApiFactory
import com.example.associationwords.data.WordsApiRepo
import com.example.associationwords.data.WordsApiRepoImpl
import com.example.associationwords.ui.SharedViewModel
import com.example.needmoreassociations.data.UserFirestoreRepo
import com.example.needmoreassociations.data.UserFirestoreRepoRepoImpl
import com.example.associationwords.data.WordsFirestoreRepo
import com.example.associationwords.data.WordsFirestoreRepoImpl
import com.example.associationwords.ui.vocabulary.VocabularyViewModel
import com.example.associationwords.utils.Android.AndroidResourceManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelsModule = module {
    viewModel { SharedViewModel(get(), get(), get()) }
    viewModel { VocabularyViewModel() }
}

val repositorySingleton = module {
    single<UserFirestoreRepo> { UserFirestoreRepoRepoImpl() }
    single<WordsFirestoreRepo> { WordsFirestoreRepoImpl() }
    single<WordsApiRepo> { WordsApiRepoImpl(get(), get()) }
}

val apiModule = module {
    factory { WordsApiFactory.wordsApi }
    factory { ResponseHandler() }
}

val androidModule = module {
    factory { AndroidResourceManager(androidContext()) }
}