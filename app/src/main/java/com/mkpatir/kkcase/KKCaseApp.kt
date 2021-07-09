package com.mkpatir.kkcase

import android.app.Application
import com.mkpatir.kkcase.internal.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KKCaseApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KKCaseApp)
            modules(appModules)
        }
    }

}