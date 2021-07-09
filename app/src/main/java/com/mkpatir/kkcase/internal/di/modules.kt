package com.mkpatir.kkcase.internal.di

import com.mkpatir.kkcase.api.AppRepository
import com.mkpatir.kkcase.api.AppRepositoryImpl
import com.mkpatir.kkcase.api.AppServiceFactory
import com.mkpatir.kkcase.ui.main.MainViewModel
import com.mkpatir.kkcase.ui.next.NextViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(true) {

    factory<AppRepository> {
        AppRepositoryImpl(
            get()
        )
    }

    factory {
        AppServiceFactory.buildService()
    }

}

val viewModelModule = module(true) {
    viewModel { MainViewModel() }
    viewModel { NextViewModel() }
}

val appModules = listOf(appModule, viewModelModule)