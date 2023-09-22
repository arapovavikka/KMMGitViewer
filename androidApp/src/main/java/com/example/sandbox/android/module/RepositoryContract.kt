package com.example.sandbox.android.module

import RepositoryInfo

class RepositoryContract {
    data class State(
        val repositories: List<RepositoryInfo> = listOf(),
        val isLoading: Boolean = false,
        var errorMessage: String? = null
    )
}