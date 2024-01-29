package com.example.homework20.presentation.state

import com.example.homework20.presentation.model.UserDisplay

data class HomePageState(
    val isLoading:Boolean = false,
    val insertionIsSuccess: UserDisplay? = null,
    val deletionIsSuccess: String? = null,
    val errorMessage:String? = null,
    val emailCheckForUpdateIsSuccess:UserDisplay? = null
)