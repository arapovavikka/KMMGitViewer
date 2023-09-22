package com.example.sandbox.android.module

import RepositoryApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sandbox.android.module.RepositoryContract
import kotlinx.coroutines.launch

class RepositoryViewModel: ViewModel() {
    var state by mutableStateOf(
        RepositoryContract.State(
            repositories = listOf(),
            isLoading = true
        )
    )
    private set

    fun loadData() {
        viewModelScope.launch {
            try {
                val repositories = RepositoryApi().getAllRepositories()
                state = state.copy(repositories = repositories, isLoading = false)
            } catch (e: Exception) {
                state = state.copy(isLoading = false, errorMessage = e.message ?: "Unknown error")
            }
        }
    }
}