package com.example.asrekaf

import android.app.Application
import timber.log.Timber

class AsrekafApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}