package com.douglas.loggingapp

import android.app.Application
import com.douglas.loggingapp.di.startKoin

class LoginApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }
}