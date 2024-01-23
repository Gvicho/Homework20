package com.example.homework20.presentation.state

data class HomePageState(
    val isLoading:Boolean = false,
    val isSuccess: String? = null,
    val errorMessage:String? = null
)