package com.example.onlineshop.presentation.fragments.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.FragmentPage1Binding
import com.example.onlineshop.presentation.MainActivity

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var latestRecyclerView: RecyclerView
    private lateinit var latestAdapter: LatestAdapter
    private lateinit var flashSaleRecyclerView: RecyclerView
    private lateinit var flashSaleAdapter: FlashSaleAdapter
    private lateinit var viewModel: Page1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[Page1ViewModel::class.java]
        (activity as MainActivity).visibleTabLayout()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.categoriesList.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading == false) {
                viewModel.latestList.observe(viewLifecycleOwner) {
                    latestAdapter.submitList(it.latest)
                }
                viewModel.flashSaleList.observe(viewLifecycleOwner) {
                    flashSaleAdapter.submitList(it.flash_sale)
                }
                binding.progressBar.visibility = View.INVISIBLE
                binding.clContent.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView() {
        categoryRecyclerView = binding.rvCategories
        categoryAdapter = CategoryAdapter()
        categoryRecyclerView.adapter = categoryAdapter
        animation(categoryRecyclerView)
        latestRecyclerView = binding.rvLatest
        latestAdapter = LatestAdapter()
        latestRecyclerView.adapter = latestAdapter
        animation(latestRecyclerView)
        flashSaleRecyclerView = binding.rvFinalSale
        flashSaleAdapter = FlashSaleAdapter()
        flashSaleRecyclerView.adapter = flashSaleAdapter
        animation(flashSaleRecyclerView)

    }

    private fun animation(recyclerView: RecyclerView) {
        val itemAnimator = recyclerView.itemAnimator
        if (itemAnimator is DefaultItemAnimator) {
            itemAnimator.supportsChangeAnimations = false
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).invisibleTabLayout()
    }
}