package com.douglas.loggingapp.feature.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglas.loggingapp.api.LoggingApi
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loggingApi: LoggingApi,
    initialState: LoginContract.State = LoginContract.State()
): ViewModel() {

    var state by mutableStateOf(initialState)
        private set

    fun onEvent(event: LoginContract.Event) {
        when(event) {
            is LoginContract.Event.OnUsernameChanged -> state = state.copy(name = event.username)
            is LoginContract.Event.OnPasswordChanged -> state = state.copy(password = event.password)
            is LoginContract.Event.OnLogInClick -> login()
        }
    }

    private fun login() = viewModelScope.launch {
        val response = loggingApi.logIn(
            userName = state.name,
            password = state.password
        )

        state = if (response.token.isNullOrBlank() || response.refreshToken.isNullOrBlank()) {
            state.copy(
                errorMsg = "User and password doesn't match",
                userLogged = false
            )
        } else {
            state.copy(
                errorMsg = "",
                userLogged = true
            )
        }
    }
}