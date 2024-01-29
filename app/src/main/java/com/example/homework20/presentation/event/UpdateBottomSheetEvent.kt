package com.example.homework20.presentation.event

import com.example.homework20.presentation.model.UserDisplay

sealed class UpdateBottomSheetEvent {
    data class UpdateUser(val user:UserDisplay):UpdateBottomSheetEvent()
    data object ResetErrorMessageToNull:UpdateBottomSheetEvent()
}