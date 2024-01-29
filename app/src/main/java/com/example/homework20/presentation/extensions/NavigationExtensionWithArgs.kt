package com.example.homework20.presentation.extensions

import android.os.Bundle
import androidx.navigation.NavController

fun NavController.safeNavigateWithArguments(actionId:Int,bundle: Bundle) {
    currentDestination?.getAction(actionId)?.run {
        navigate(actionId,bundle)
    }
}