package com.douglas.loggingapp.feature.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.douglas.loggingapp.ui.theme.LoggingAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<LoginViewModel>()

    LoggingAppTheme {
        Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
            LoginView(
                modifier = Modifier.padding(innerPadding),
                onEvent = viewModel::onEvent,
                state = viewModel.state
            )
        }
    }
}