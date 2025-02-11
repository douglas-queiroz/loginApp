package com.douglas.loggingapp.api

interface LoggingApi {

    suspend fun logIn(userName: String, password: String) : Response
}