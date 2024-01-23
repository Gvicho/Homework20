package com.example.homework20.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val uid: Int,
    val firstName: String,
    val lastName: String,
    val age:Int,
    val mail:String
) {
}