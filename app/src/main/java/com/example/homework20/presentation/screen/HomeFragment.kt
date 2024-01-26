package com.example.homework20.presentation.screen

import android.graphics.Color
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.homework20.databinding.FragmentHomeBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.HomePageEvent
import com.example.homework20.presentation.extensions.showSnackBar
import com.example.homework20.presentation.model.Status
import com.example.homework20.presentation.model.UserDisplay
import com.example.homework20.presentation.state.HomePageState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel:HomeViewModel by viewModels()

    override fun bindObservers() {
        setOnStateListener()
    }

    private fun setOnStateListener(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect{
                    handleResult(it)
                }
            }
        }
    }

    private fun handleResult(state:HomePageState){
        state.errorMessage?.let {
            showErrorMessage(it)
            viewModel.onEvent(HomePageEvent.ResetErrorMessageToNull)
            outputStatusMessage(false)
        }

        showLoader(state.isLoading)

        state.insertionIsSuccess?.let {
            successfulInsertionOnEmail(it.email)
            outputStatusMessage(true)
        }

        state.deletionIsSuccess?.let {
            successfulDeletion(it)
            outputStatusMessage(true)
        }
    }

    private fun showErrorMessage(errorMessage:String){
        binding.root.showSnackBar(errorMessage)
    }

    override fun bindViewActionListeners() {
        setAddUserBtnClickListener()
    }

    private fun setAddUserBtnClickListener(){
        binding.apply {
            btnAddUser.setOnClickListener{

                val fName = edtFName.text.toString()
                val lName = edtLName.text.toString()
                val age = edtAge.text.toString().toInt()
                val mail = edtEmail.text.toString()

                viewModel.onEvent(
                    HomePageEvent.AddUser(
                        UserDisplay(
                            fName=fName,
                            lName = lName,
                            age = age,
                            email = mail
                        )
                    )
                )



            }

            btnRemoveUse.setOnClickListener {
                val fName = edtFName.text.toString()
                val lName = edtLName.text.toString()
                val age = edtAge.text.toString().toInt()
                val mail = edtEmail.text.toString()

                viewModel.onEvent(
                    HomePageEvent.RemoveUser(
                        firstName=fName,
                        lastName = lName,
                        age = age,
                        email = mail
                    )
                )
            }
        }

    }

    private fun outputStatusMessage(status:Boolean){
        binding.apply {
            tvStatus.visibility = View.VISIBLE
            if(status){
                tvStatus.text = Status.SUCCESSFUL.toString()
                tvStatus.setTextColor(Color.GREEN)
            }else{
                tvStatus.text = Status.ERROR.toString()
                tvStatus.setTextColor(Color.RED)
            }
        }

    }

    private fun showLoader(loading:Boolean){
        binding.progressBar.visibility = if(loading)View.VISIBLE else View.GONE
    }

    private fun successfulInsertionOnEmail(email:String){
        binding.root.showSnackBar(
            "user added on email: $email"
        )
    }

    private fun successfulDeletion(email:String){
        binding.root.showSnackBar(
            "user deleted on email: $email"
        )
    }
}