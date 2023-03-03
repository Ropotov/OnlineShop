package com.example.onlineshop

import android.app.Application
import com.example.onlineshop.di.DaggerAppComponent

class App : Application() {

  val component by lazy {
    DaggerAppComponent.factory().create(this)
  }

  override fun onCreate() {
    component.inject(this)
    super.onCreate()
  }
}