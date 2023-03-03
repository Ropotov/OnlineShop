package com.example.onlineshop.presentation.fragments.welcomeBackFragment

import android.content.Context
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentWelcomeBackBinding
import com.example.onlineshop.di.ViewModelFactory
import com.example.onlineshop.domain.models.User
import com.example.onlineshop.presentation.dismissKeyboard
import com.example.onlineshop.presentation.isNameValid
import com.example.onlineshop.presentation.showSnackBar
import com.example.onlineshop.presentation.textIsEmpty
import javax.inject.Inject

class WelcomeBackFragment : Fragment() {

  private lateinit var binding: FragmentWelcomeBackBinding
  private lateinit var viewModel: WelcomeBackViewModel

  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  private val component by lazy {
    (requireActivity().application as App).component
  }

  override fun onAttach(context: Context) {
    component.inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    binding = FragmentWelcomeBackBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this, viewModelFactory)[WelcomeBackViewModel::class.java]
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.btnLogIn.setOnClickListener {
      login()
      hidePassword()
    }
    binding.checkBox.setOnCheckedChangeListener { _, _ ->
      if (binding.checkBox.isChecked) {
        binding.etPasswordText.transformationMethod = HideReturnsTransformationMethod()
      } else {
        binding.etPasswordText.transformationMethod = PasswordTransformationMethod()
      }
    }
  }

  private fun hidePassword() {
    binding.checkBox.setOnCheckedChangeListener { _, _ ->
      if (binding.checkBox.isChecked) {
        binding.etPasswordText.transformationMethod = HideReturnsTransformationMethod()
      } else {
        binding.etPasswordText.transformationMethod = PasswordTransformationMethod()
      }
    }
  }

  private fun login() {
    dismissKeyboard(requireActivity())
    val login = binding.etFirstName.text.toString()
    val password = binding.etPasswordText.text.toString()
    var listUser = emptyList<User>()
    viewModel.listUser.observe(viewLifecycleOwner) {
      listUser = it
    }
    when {
      textIsEmpty(login) -> showSnackBar(binding.constraint, getString(R.string.login_is_empty))
      textIsEmpty(password) -> showSnackBar(binding.constraint, getString((R.string.pass_is_empty)))
      !isNameValid(login) -> showSnackBar(binding.constraint, getString(R.string.Invalid_login))
      else -> {
        val user = viewModel.searchUser(listUser, login)
        if (user != null) {
          if (password == user.password) {
            findNavController().navigate(R.id.action_welcomeBackFragment2_to_viewPagerFragment)
          } else {
            showSnackBar(binding.constraint, getString(R.string.Invalid_password))
          }
        } else {
          showSnackBar(binding.constraint, getString(R.string.not_login))
        }
      }
    }
  }
}
