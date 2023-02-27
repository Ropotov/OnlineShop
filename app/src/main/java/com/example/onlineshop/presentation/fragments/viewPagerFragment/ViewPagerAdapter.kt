package com.example.onlineshop.presentation.fragments.viewPagerFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onlineshop.presentation.fragments.page1.Page1Fragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Page1Fragment()
            else -> Page1Fragment()
        }
    }
}