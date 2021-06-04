package com.example.projectfoodpedia.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

// List dari berbagai macam dependecy yang dapat di inject di berbagai macam class
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BaseApp)
            modules(
                    listOf(
                            databaseModule,
                            repositoryModule,
                            viewModel,
                        useCaseModule,
                        networkModule
                    )
            )
        }
    }
}