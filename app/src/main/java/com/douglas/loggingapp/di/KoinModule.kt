package com.douglas.loggingapp.di

import com.douglas.loggingapp.api.LoggingApi
import com.douglas.loggingapp.api.LoggingApiMock
import com.douglas.loggingapp.feature.login.LoginViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun startKoin()  = startKoin {
    modules(listOf(
        apiModule,
        viewModelModule
    ))
}

val apiModule = module {
    factory<LoggingApi> { LoggingApiMock() }
}

val viewModelModule = module {
    viewModel { LoginViewModel(loggingApi = get()) }
}