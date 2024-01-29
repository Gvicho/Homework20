package com.example.homework20.presentation.state

data class UpdateBottomSheetState(
    val errorMessage:String? = null,
    var updateIsSuccess:Unit? = null
) {
}