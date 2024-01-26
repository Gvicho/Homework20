package com.example.homework20.presentation.mapper

import com.example.homework20.domain.model.User
import com.example.homework20.presentation.model.UserDisplay

fun UserDisplay.toDomain(): User {
    return User(
        id = id,
        fName = fName,
        lName = fName,
        age = age,
        email = email
    )
}

fun User.toPresenter():UserDisplay{
    return UserDisplay(
        id = id,
        fName = fName,
        lName = fName,
        age = age,
        email = email
    )
}