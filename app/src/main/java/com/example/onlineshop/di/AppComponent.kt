package com.example.onlineshop.di

import android.app.Application
import com.example.onlineshop.App
import com.example.onlineshop.presentation.activity.ContentActivity
import com.example.onlineshop.presentation.activity.MainActivity
import com.example.onlineshop.presentation.fragments.page1.Page1Fragment
import com.example.onlineshop.presentation.fragments.profileFragment.ProfileFragment
import com.example.onlineshop.presentation.fragments.signInFragment.SignInFragment
import com.example.onlineshop.presentation.fragments.welcomeBackFragment.WelcomeBackFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

  fun inject(fragment: Page1Fragment)
  fun inject(fragment: ProfileFragment)
  fun inject(fragment: SignInFragment)
  fun inject(fragment: WelcomeBackFragment)
  fun inject(activity: MainActivity)
  fun inject(activity: ContentActivity)
  fun inject(application: App)

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance application: Application
    ): AppComponent
  }
}