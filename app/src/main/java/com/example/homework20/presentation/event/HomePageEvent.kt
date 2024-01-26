package com.example.homework20.presentation.event

import com.example.homework20.presentation.model.UserDisplay

sealed class HomePageEvent {
    data class AddUser(val userDisplay:UserDisplay):HomePageEvent()
    data class RemoveUser(val email: String,val firstName: String,val lastName: String,val age: Int):HomePageEvent()
    data class UpdateUser(val email:String):HomePageEvent()
    data object ResetErrorMessageToNull:HomePageEvent()
}