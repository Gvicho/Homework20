package com.example.homework20.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.domain.usecase.InsertUserUseCase
import com.example.homework20.presentation.event.HomePageEvent
import com.example.homework20.presentation.mapper.toDomain
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
    private val insertUserUseCase: InsertUserUseCase
):ViewModel() {
    private val _uiStateFlow = MutableStateFlow(HomePageState())
    val uiStateFlow : StateFlow<HomePageState> = _uiStateFlow

    fun onEvent(event: HomePageEvent){
        when(event){
            is HomePageEvent.AddUser -> {
                addUser(event.userDisplay)
            }
            is HomePageEvent.RemoveUser -> TODO()
            is HomePageEvent.UpdateUser -> TODO()
        }
    }

    private fun addUser(userDisplay: UserDisplay){
        viewModelScope.launch(Dispatchers.IO) {
            insertUserUseCase(userDisplay.toDomain())
            _uiStateFlow.update { it.copy(isSuccess = "Success") }
        }
    }
}