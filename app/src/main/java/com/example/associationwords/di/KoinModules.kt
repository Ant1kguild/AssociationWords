package com.example.associationwords.di

import com.example.associationwords.ui.SharedViewModel
import com.example.needmoreassociations.data.UserRepository
import com.example.needmoreassociations.data.UserRepositoryImpl
import com.example.needmoreassociations.data.WordsRepository
import com.example.needmoreassociations.data.WordsRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelsModule = module {
    viewModel { SharedViewModel(get(), get()) }
}

val repositorySingleton = module {
    single<UserRepository> { UserRepositoryImpl() }
    single<WordsRepository> { WordsRepositoryImpl() }
}