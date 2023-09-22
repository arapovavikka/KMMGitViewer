package com.example.sandbox.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.sandbox.android.module.RepositoryModuleView
import com.example.sandbox.android.module.RepositoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                RepositoryApp()
            }
        }
    }
}

@Composable
private fun RepositoryApp() {
    val viewModel = RepositoryViewModel()
    RepositoryModuleView(viewModel)
}
