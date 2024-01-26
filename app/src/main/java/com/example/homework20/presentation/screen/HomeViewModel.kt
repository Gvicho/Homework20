package com.example.homework20.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.domain.usecase.DeleteSafeUserUseCase
import com.example.homework20.domain.usecase.InsertSafeUserUseCase
import com.example.homework20.presentation.event.HomePageEvent
import com.example.homework20.presentation.mapper.toDomain
import com.example.homework20.presentation.mapper.toPresenter
import com.example.homework20.presentation.model.UserDisplay
import com.example.homework20.presentation.state.HomePageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val insertSafeUserUseCase: InsertSafeUserUseCase,
    private val deleteSafeUserUseCase: DeleteSafeUserUseCase
):ViewModel() {
    private val _uiStateFlow = MutableStateFlow(HomePageState())
    val uiStateFlow : StateFlow<HomePageState> = _uiStateFlow

    fun onEvent(event: HomePageEvent){
        when(event){
            is HomePageEvent.AddUser -> {
                addUser(event.userDisplay)
            }
            is HomePageEvent.RemoveUser -> {
                event.run {
                    removeUser(
                        email = email,
                        firstName = firstName,
                        lastName = lastName,
                        age = age
                    )
                }
            }
            is HomePageEvent.UpdateUser -> TODO()
            is HomePageEvent.ResetErrorMessageToNull -> {
                resetErrorMessageToNull()
            }
        }
    }

    private fun removeUser(email: String, firstName: String, lastName: String, age: Int){
        viewModelScope.launch {
            val userEmail = deleteSafeUserUseCase(
                email = email,
                firstName = firstName,
                lastName = lastName,
                age = age)
            _uiStateFlow.update {
                if (userEmail == null){
                    it.copy(deletionIsSuccess = null, errorMessage = "user doesn't exist",insertionIsSuccess = null)
                }else{
                    it.copy(deletionIsSuccess = userEmail,insertionIsSuccess = null)
                }
            }
        }
    }

    private fun addUser(userDisplay: UserDisplay){
        viewModelScope.launch(Dispatchers.IO) {
            val user = insertSafeUserUseCase(userDisplay.toDomain())?.toPresenter()
            _uiStateFlow.update {
                if(user == null){
                    it.copy(insertionIsSuccess = null, errorMessage = "user already exists",deletionIsSuccess = null)
                }else{
                    it.copy(insertionIsSuccess = user,deletionIsSuccess = null)
                }


            }
        }
    }


    private fun resetErrorMessageToNull(){
        _uiStateFlow.update {
            it.copy(errorMessage = null)
        }
    }
}