package com.example.homework20.presentation.screen.update_bottomsheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.domain.usecase.UpdateUserUseCase
import com.example.homework20.presentation.event.UpdateBottomSheetEvent
import com.example.homework20.presentation.mapper.toDomain
import com.example.homework20.presentation.model.UserDisplay
import com.example.homework20.presentation.state.UpdateBottomSheetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateBottomSheetViewModel  @Inject constructor(
    private val updateUserUseCase: UpdateUserUseCase
):ViewModel() {

    private val _uiStateFlow = MutableStateFlow(UpdateBottomSheetState())
    val uiStateFlow : StateFlow<UpdateBottomSheetState> = _uiStateFlow


    fun onEvent(event: UpdateBottomSheetEvent){
        when(event){
            is UpdateBottomSheetEvent.ResetErrorMessageToNull -> {
                resetErrorToNull()
            }
            is UpdateBottomSheetEvent.UpdateUser -> {
                updateUser(event.user)
            }
        }
    }

    private fun updateUser(user:UserDisplay){
        viewModelScope.launch {
            updateUserUseCase(user.toDomain())
            _uiStateFlow.update {
                it.copy(updateIsSuccess = Unit)
            }
        }
    }

    private fun resetErrorToNull(){
        _uiStateFlow.update {
            it.copy(errorMessage = null)
        }
    }
}