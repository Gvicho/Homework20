package com.example.homework20.domain.usecase.validations

import javax.inject.Inject

class ValidateAgeUseCase @Inject constructor() {

    operator fun invoke(age:String):Int{

        try {

            val ageNum = age.toInt()

            if(ageNum in 0..100){
                return ageNum
            }

        }catch(_:Exception){

        }

        return -1
    }

}