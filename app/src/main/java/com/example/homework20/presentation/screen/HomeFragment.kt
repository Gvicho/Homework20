package com.example.homework20.presentation.screen

import androidx.fragment.app.viewModels
import com.example.homework20.databinding.FragmentHomeBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.HomePageEvent
import com.example.homework20.presentation.model.UserDisplay
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel:HomeViewModel by viewModels()

    override fun bind() {
        setAddUserBtnClickListener()
    }

    private fun setAddUserBtnClickListener(){
        binding.btnAddUser.setOnClickListener{

            binding.apply {
                val fName = edtFName.text.toString()
                val lName = edtLName.text.toString()
                val age = edtAge.text.toString().toInt()
                val mail = edtEmail.text.toString()

                    viewModel.onEvent(
                        HomePageEvent.AddUser(
                            UserDisplay(
                                15,
                                fName,
                                lName,
                                age,
                                mail
                            )
                        )
                    )
            }


        }
    }
}