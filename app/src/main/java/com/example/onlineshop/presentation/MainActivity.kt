package com.example.onlineshop.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.App
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private var backPressed: Long = 0

  private lateinit var binding: ActivityMainBinding


  private val component by lazy {
    (application as App).component
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    component.inject(this)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

  }

  @Deprecated("Deprecated in Java")
  override fun onBackPressed() {
    if (backPressed + 2000 > System.currentTimeMillis()) {
      super.onBackPressed()
      finish()
    } else {
      showSnackBar(binding.container, getString(R.string.backPressed))
    }
    backPressed = System.currentTimeMillis()
  }
}
