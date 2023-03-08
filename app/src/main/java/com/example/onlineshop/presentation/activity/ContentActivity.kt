package com.example.onlineshop.presentation.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityContentBinding
import com.example.onlineshop.di.ViewModelFactory
import javax.inject.Inject

class ContentActivity : AppCompatActivity() {

  private lateinit var binding: ActivityContentBinding
  private lateinit var navController: NavController

  private val menuToolbar: Menu? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityContentBinding.inflate(layoutInflater)
    setContentView(binding.root)

    navController = Navigation.findNavController(this, R.id.navFragment)
    binding.mainContent.bottomNavigation.setupWithNavController(navController)
    setDestinationController()
  }

  private fun setDestinationController() {
    navController.addOnDestinationChangedListener { _, destination, _ ->
      if (destination.id == R.id.page1Fragment) {
        binding.toolBar.visibility = View.VISIBLE
        menuToolbar?.let { it.findItem(R.id.imagePhoto).isVisible = true }
      } else {
        binding.toolBar.visibility = View.GONE
        menuToolbar?.let { it.findItem(R.id.imagePhoto).isVisible = false }
      }
    }
  }
}
