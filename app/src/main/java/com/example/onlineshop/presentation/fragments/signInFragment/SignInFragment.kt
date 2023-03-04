package com.example.onlineshop.presentation.fragments.signInFragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentSignInBinding
import com.example.onlineshop.di.ViewModelFactory
import com.example.onlineshop.domain.models.User
import com.example.onlineshop.presentation.*
import com.example.onlineshop.presentation.activity.ContentActivity
import javax.inject.Inject

class SignInFragment : Fragment() {

  private lateinit var binding: FragmentSignInBinding
  private lateinit var viewModel: SignInViewModel

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
    binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this, viewModelFactory)[SignInViewModel::class.java]
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.btnSignIn.setOnClickListener {
      registration()
    }
    binding.tvLogin.setOnClickListener {
      findNavController().navigate(R.id.action_singInFragment_to_welcomeBackFragment2)
    }
  }

  private fun registration() {
    dismissKeyboard(requireActivity())
    val firstName = binding.etFirstName.text.toString()
    val lastName = binding.etLastName.text.toString()
    val email = binding.etSingInEmail.text.toString()
    var listUser = emptyList<User>()
    viewModel.listUser.observe(viewLifecycleOwner) {
      listUser = it
    }

    when {
      textIsEmpty(firstName) -> showSnackBar(
        binding.constraint,
        getString(R.string.first_name_is_empty)
      )
      !isNameValid(firstName) -> showSnackBar(
        binding.constraint,
        getString(R.string.Invalid_first_name)
      )
      textIsEmpty(lastName) -> showSnackBar(
        binding.constraint,
        getString(R.string.last_name_is_empty)
      )
      !isNameValid(lastName) -> showSnackBar(
        binding.constraint,
        getString(R.string.Invalid_last_name)
      )
      textIsEmpty(email) -> showSnackBar(binding.constraint, getString(R.string.email_is_empty))
      !isEmailValid(email) -> showSnackBar(binding.constraint, getString(R.string.Invalid_email))
      else -> {
        val user = viewModel.searchUser(listUser, firstName)
        if (user != null) {
          showSnackBar(binding.constraint, getString(R.string.already_login))
        } else {
          viewModel.addAccount(
            User(
              firstName = binding.etFirstName.text.toString(),
              lastName = binding.etFirstName.text.toString(),
              email = binding.etSingInEmail.text.toString(),
              password = binding.etLastName.text.toString()
            )
          )
          showSnackBar(binding.constraint, getString(R.string.registered))
          startActivity(Intent(requireContext(), ContentActivity::class.java))
        }
      }
    }
  }
}
