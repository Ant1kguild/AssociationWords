package com.example.associationwords.di

import com.example.associationwords.api.WordsApi
import com.example.associationwords.api.WordsApiFactory
import com.example.associationwords.ui.SharedViewModel
import com.example.needmoreassociations.data.UserFirestoreRepo
import com.example.needmoreassociations.data.UserFirestoreRepoRepoImpl
import com.example.needmoreassociations.data.WordsRepository
import com.example.needmoreassociations.data.WordsRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelsModule = module {
    viewModel { SharedViewModel(get(), get()) }
}

val repositorySingleton = module {
    single<UserFirestoreRepo> { UserFirestoreRepoRepoImpl() }
    single<WordsRepository> { WordsRepositoryImpl() }
}

val apiModule = module {
    factory<WordsApi> {WordsApiFactory.wordsApi}
}