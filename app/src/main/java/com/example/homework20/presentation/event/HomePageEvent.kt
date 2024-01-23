package com.example.homework20.presentation.event

import com.example.homework20.presentation.model.UserDisplay

sealed class HomePageEvent {
    data class AddUser(val userDisplay:UserDisplay):HomePageEvent()
    data class RemoveUser(val userDisplay:UserDisplay):HomePageEvent()
    data class UpdateUser(val email:String):HomePageEvent()
}