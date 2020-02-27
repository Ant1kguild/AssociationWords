package com.example.associationwords.di

import com.example.associationwords.ui.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModels = module {
    viewModel{SharedViewModel()}
}

val repositorySingleton = module {

}