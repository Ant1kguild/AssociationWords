package com.example.associationwords

import android.app.Application
import android.content.res.Resources
import com.example.associationwords.di.androidModule
import com.example.associationwords.di.apiModule
import com.example.associationwords.di.repositorySingleton
import com.example.associationwords.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelsModule, repositorySingleton, apiModule, androidModule))
        }
    }
}