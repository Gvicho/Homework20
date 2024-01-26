package com.example.homework20.presentation.model

data class UserDisplay(
    val id:Int =0,
    val fName:String,
    val lName:String,
    val age:Int,
    val email:String
)

enum class Status{
    SUCCESSFUL,
    ERROR
}