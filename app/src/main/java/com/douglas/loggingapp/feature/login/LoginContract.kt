package com.douglas.loggingapp.feature.login

class LoginContract {

    data class State (
        val name: String = "",
        val password: String = "",
        val errorMsg: String = "",
        val userLogged: Boolean = false
    )

    sealed class Event {
        data class OnUsernameChanged(val username: String) : Event()
        data class OnPasswordChanged(val password: String) : Event()
        data object OnLogInClick: Event()
    }
}