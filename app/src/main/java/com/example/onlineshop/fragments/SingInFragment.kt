package com.example.onlineshop.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.*
import com.example.onlineshop.database.dataBase
import com.example.onlineshop.databinding.FragmentSingInBinding

class SingInFragment : Fragment() {

    lateinit var binding: FragmentSingInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSingIn.setOnClickListener {
            registration(requireContext())
        }
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_singInFragment_to_welcomeBackFragment2)
        }
    }

    private fun registration(context: Context) {
        dismissKeyboard(requireActivity())
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val email = binding.etSingInEmail.text.toString()

        when {
            textIsEmpty(firstName) -> showToast(context, getString(R.string.first_name_is_empty))
            textIsEmpty(lastName) -> showToast(context, getString(R.string.last_name_is_empty))
            textIsEmpty(email) -> showToast(context, getString(R.string.email_is_empty))
            !isNameValid(firstName) -> showToast(context, getString(R.string.Invalid_first_name))
            !isNameValid(lastName) -> showToast(context, getString(R.string.Invalid_last_name))
            !isEmailValid(email) -> showToast(context, getString(R.string.Invalid_email))
            dataBase.containsKey(firstName) -> showToast(context, getString(R.string.already_login))
            else -> {
                dataBase[firstName] = lastName
                showToast(context, getString(R.string.registered))
                findNavController().navigate(R.id.action_singInFragment_to_welcomeBackFragment2)
            }
        }
    }
}