package com.example.onlineshop.presentation.fragments.viewPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = ViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.icon = getDrawable(requireContext(), R.drawable.tab_home)
                1 -> tab.icon = getDrawable(requireContext(), R.drawable.tab_favorite)
                2 -> tab.icon = getDrawable(requireContext(), R.drawable.tab_basket)
                3 -> tab.icon = getDrawable(requireContext(), R.drawable.tab_comments)
                else -> tab.icon = getDrawable(requireContext(), R.drawable.tab_profile)
            }
        }.attach()
    }
}