package com.douglas.loggingapp.api

import kotlinx.coroutines.delay

class LoggingApiMock: LoggingApi {

    override suspend fun logIn(userName: String, password: String): Response {
        delay(1000)

        return if (userName == "Oscar" && password == "123") {
            Response(token = "token", refreshToken = "refreshToken")
        } else {
            Response()
        }
    }
}