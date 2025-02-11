package com.douglas.loggingapp.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.douglas.loggingapp.ui.theme.LoggingAppTheme

@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    state: LoginContract.State,
    onEvent: (LoginContract.Event) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        OutlinedTextField(value = state.name, label = {
            Text("Login")
        }, onValueChange = {
            onEvent(LoginContract.Event.OnUsernameChanged(it))
        })

        OutlinedTextField(
            value = state.password,
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text("Password")
            }, onValueChange = {
                onEvent(LoginContract.Event.OnPasswordChanged(it))
            }
        )

        if (state.errorMsg.isNotEmpty()) {
            Text(
                text = state.errorMsg,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (state.userLogged) {
            Text(
                text = "Success",
            )
        }

        Button({
            onEvent(LoginContract.Event.OnLogInClick)
        }) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoggingAppTheme {
        LoginView(
            state = LoginContract.State(name = "Oscar", password = "1234", errorMsg = "Login or Password doesn't match"),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewLogged() {
    LoggingAppTheme {
        LoginView(
            state = LoginContract.State(name = "Oscar", password = "1234", userLogged = true),
            onEvent = {}
        )
    }
}