package com.example.homework20.data.local.mapper

import com.example.homework20.data.local.model.UserEntity
import com.example.homework20.domain.model.User

fun UserEntity.toDomain():User{
    return User(
        id = id,
        fName = firstName,
        lName = lastName,
        age = age,
        email = mail
    )
}

fun User.toEntity():UserEntity{
    return UserEntity(
        id = id,
        firstName=fName  ,
        lastName=lName  ,
        age = age,
        mail= email
    )
}