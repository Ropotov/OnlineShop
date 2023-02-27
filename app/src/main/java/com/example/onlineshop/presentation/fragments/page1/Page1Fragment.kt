package com.example.onlineshop.presentation.fragments.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.onlineshop.databinding.FragmentPage1Binding

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private lateinit var viewModel: Page1ViewModel
    private val adapter = ContentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[Page1ViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.items = it
        }

        with(binding) {
            recyclerView.adapter = adapter
        }
    }
}