package com.example.onlineshop.di

import androidx.lifecycle.ViewModel
import com.example.onlineshop.presentation.fragments.page1.Page1ViewModel
import com.example.onlineshop.presentation.fragments.profileFragment.ProfileViewModel
import com.example.onlineshop.presentation.fragments.signInFragment.SignInViewModel
import com.example.onlineshop.presentation.fragments.welcomeBackFragment.WelcomeBackViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(Page1ViewModel::class)
  fun bindPage1ViewModel(viewModel: Page1ViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(ProfileViewModel::class)
  fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SignInViewModel::class)
  fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(WelcomeBackViewModel::class)
  fun bindWelcomeBackViewModel(viewModel: WelcomeBackViewModel): ViewModel
}