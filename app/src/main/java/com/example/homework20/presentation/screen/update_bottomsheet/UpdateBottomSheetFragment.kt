package com.example.homework20.presentation.screen.update_bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.homework20.databinding.FragmentBottomSheetUpdateBinding
import com.example.homework20.presentation.event.UpdateBottomSheetEvent
import com.example.homework20.presentation.extensions.showSnackBar
import com.example.homework20.presentation.model.UserDisplay
import com.example.homework20.presentation.state.UpdateBottomSheetState
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpdateBottomSheetFragment: BottomSheetDialogFragment() {

    private var binding:FragmentBottomSheetUpdateBinding? = null
    private val viewModel:UpdateBottomSheetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBottomSheetUpdateBinding.inflate(inflater)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("id")
        val email = arguments?.getString("mail")

        if(noneIsNotNull(id,email)){
            bindBottomSheetActionListeners(id!!,email!!)
            bindObservers()
        }else{
            showFailedArgumentPass()
        }

    }

    private fun bindObservers(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect{
                    handleResponse(it)
                }
            }
        }
    }

    private fun handleResponse(state:UpdateBottomSheetState){
        state.errorMessage?.let {
            showErrorMessage(it)
        }

        state.updateIsSuccess?.let {
            finishBottomSheet()
        }
    }

    private fun finishBottomSheet(){
        findNavController().popBackStack()
    }


    private fun showErrorMessage(errorMessage:String){
        binding!!.root.showSnackBar(errorMessage)
    }

    private fun bindBottomSheetActionListeners(id:Int,email: String){
        binding!!.apply {
            updateUserBtn.setOnClickListener {
                updateUser(id,email)
            }
        }
    }

    private fun updateUser(id:Int,email: String){
        binding!!.run {
            val fName = edtFName.text.toString()
            val lName = edtLName.text.toString()
            val age = edtAge.text.toString().toInt()

            val user = UserDisplay(id,fName,lName,age,email)

            viewModel.onEvent(
                UpdateBottomSheetEvent.UpdateUser(user)
            )
        }
    }

    private fun showFailedArgumentPass(){
        binding!!.root.showSnackBar("Error passing user Information")
    }

    private fun noneIsNotNull(id:Int?,email:String?) :Boolean{
        return !(id==null || email == null)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}