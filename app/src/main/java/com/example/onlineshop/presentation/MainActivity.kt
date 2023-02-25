package com.example.onlineshop.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun visibleTabLayout() {
       binding.tabLayout.visibility = View.VISIBLE
    }
    fun invisibleTabLayout() {
        binding.tabLayout.visibility = View.INVISIBLE
    }
}
