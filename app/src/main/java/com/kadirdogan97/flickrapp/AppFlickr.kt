package com.kadirdogan97.flickrapp

import android.app.Application
import com.kadirdogan97.flickrapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

class AppFlickr : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppFlickr)
            modules(listOf(networkModules, dataSourceModules, repositoryModules, useCaseModules, viewModelModules))
        }
    }
}