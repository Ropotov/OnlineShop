package com.example.onlineshop.presentation.fragments.profileFragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentProfileBinding
import com.example.onlineshop.di.ViewModelFactory
import com.example.onlineshop.presentation.fragments.welcomeBackFragment.WelcomeBackFragment
import javax.inject.Inject


class ProfileFragment : Fragment() {

  private lateinit var binding: FragmentProfileBinding
  private lateinit var viewModel: ProfileViewModel

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
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val profileAdapter = ProfileAdapter()
    binding.recyclerView.adapter = profileAdapter
    viewModel.listProfileItem.observe(viewLifecycleOwner) {
      profileAdapter.items = it
    }
    binding.btnUpload.setOnClickListener {
      selectImageFromGallery()
    }
    profileAdapter.itemClickListener = {
      requireActivity().supportFragmentManager
        .beginTransaction().replace(R.id.container, WelcomeBackFragment())
        .commit()
    }
  }

  private val selectImageFromGalleryResult =
    registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
      uri?.let { binding.imageView.setImageURI(uri) }
    }

  private fun selectImageFromGallery() =
    selectImageFromGalleryResult.launch("image/*")

}
