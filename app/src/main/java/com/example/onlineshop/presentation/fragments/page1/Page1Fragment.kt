package com.example.onlineshop.presentation.fragments.page1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.onlineshop.App
import com.example.onlineshop.databinding.FragmentPage1Binding
import com.example.onlineshop.di.ViewModelFactory
import javax.inject.Inject

class Page1Fragment : Fragment() {

  private lateinit var binding: FragmentPage1Binding
  private lateinit var viewModel: Page1ViewModel

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
    binding = FragmentPage1Binding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this, viewModelFactory)[Page1ViewModel::class.java]
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val contentAdapter = ContentAdapter()
    viewModel.data.observe(viewLifecycleOwner) {
      contentAdapter.items = it
    }
    val categoryAdapter = CategoryAdapter()
    viewModel.category.observe(viewLifecycleOwner) {
      categoryAdapter.items = it
    }

    with(binding) {
      recyclerView.adapter = contentAdapter
      recyclerViewCategory.adapter = categoryAdapter
    }
  }
}