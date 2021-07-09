package com.mkpatir.kkcase.internal.di

import com.mkpatir.kkcase.api.AppRepository
import com.mkpatir.kkcase.api.AppRepositoryImpl
import com.mkpatir.kkcase.api.AppServiceFactory
import com.mkpatir.kkcase.api.AuthTokenInterceptor
import com.mkpatir.kkcase.cache.DBManager
import com.mkpatir.kkcase.internal.helpers.SharedPrefHelper
import com.mkpatir.kkcase.ui.main.MainViewModel
import com.mkpatir.kkcase.ui.next.NextViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(true) {

    single { SharedPrefHelper(androidContext()) }
    single { AuthTokenInterceptor(get()) }
    single { DBManager.getOrCreateDBManager(androidContext()) }

    factory<AppRepository> {
        AppRepositoryImpl(
            get()
        )
    }

    factory {
        AppServiceFactory.buildService(
            get()
        )
    }

}

val viewModelModule = module(true) {
    viewModel { MainViewModel(get(), get()) }
    viewModel { NextViewModel(get(), get()) }
}

val appModules = listOf(appModule, viewModelModule)