package com.douglas.loggingapp.api

class LoggingApiMock: LoggingApi {

    override suspend fun logIn(userName: String, password: String): Response {
        return if (userName == "Oscar" && password == "123") {
            Response(token = "token", refreshToken = "refreshToken")
        } else {
            Response()
        }
    }
}