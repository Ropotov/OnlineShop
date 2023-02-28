package com.example.onlineshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.R
import com.example.onlineshop.data.database.dataBase
import com.example.onlineshop.databinding.FragmentWelcomeBackBinding
import com.example.onlineshop.presentation.dismissKeyboard
import com.example.onlineshop.presentation.isNameValid
import com.example.onlineshop.presentation.showToast
import com.example.onlineshop.presentation.textIsEmpty

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
        binding.checkBox.setOnCheckedChangeListener { _, _ ->
            if (binding.checkBox.isChecked) {
                binding.etPasswordText.transformationMethod = HideReturnsTransformationMethod()
            } else {
                binding.etPasswordText.transformationMethod = PasswordTransformationMethod()
            }
        }
    }

    private fun login(context: Context) {
        dismissKeyboard(requireActivity())
        val login = binding.etFirstName.text.toString()
        val password = binding.etPasswordText.text.toString()
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
                findNavController().navigate(R.id.action_welcomeBackFragment2_to_viewPagerFragment)
            }
        }
    }
}