    package com.douglas.loggingapp.feature.login

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.Button
    import androidx.compose.material3.CircularProgressIndicator
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.OutlinedTextField
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.input.PasswordVisualTransformation
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.douglas.loggingapp.ui.theme.LoggingAppTheme

    @Composable
    fun LoginView(
        modifier: Modifier = Modifier,
        state: LoginContract.State,
        onEvent: (LoginContract.Event) -> Unit
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
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


                Row {
                    TextButton({
                        onEvent(LoginContract.Event.OnLogInClick)
                    }) {
                        Text("Forgot Password")
                    }

                    Button({
                        onEvent(LoginContract.Event.OnLogInClick)
                    }) {
                        Text("Login")
                    }
                }
            }

            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize().background(Color(0, 0, 0, 100)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
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

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreviewLoadign() {
        LoggingAppTheme {
            LoginView(
                state = LoginContract.State(name = "Oscar", password = "1234", isLoading = true),
                onEvent = {}
            )
        }
    }