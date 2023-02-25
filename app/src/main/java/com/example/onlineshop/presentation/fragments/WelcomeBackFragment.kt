package com.example.onlineshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.*
import com.example.onlineshop.data.database.dataBase
import com.example.onlineshop.databinding.FragmentWelcomeBackBinding

class WelcomeBackFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBackBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogIn.setOnClickListener {
            login(requireContext())
        }
    }

    private fun login(context: Context) {
        dismissKeyboard(requireActivity())
        val login = binding.etFirstName.text.toString()
        val password = binding.etPassword.text.toString()
        when {
            textIsEmpty(login) -> showToast(context, getString(R.string.login_is_empty))
            textIsEmpty(password) -> showToast(context, getString((R.string.pass_is_empty)))
            !isNameValid(login) -> showToast(context, getString(R.string.Invalid_login))
            !dataBase.containsKey(login) -> showToast(context, getString(R.string.not_login))
            dataBase.getValue(login) != password -> showToast(
                context,
                getString(R.string.Invalid_password)
            )
            else -> {
                findNavController().navigate(R.id.action_welcomeBackFragment2_to_page1Fragment)
            }
        }
    }
}