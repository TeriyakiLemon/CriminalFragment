package com.example.criminalintent

import android.app.Application

class CriminalIntentApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        CrimeRespository.initialize(this)
    }
}