package com.example.onlineshop.presentation.fragments.welcomeBackFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.domain.DataBaseRepository
import com.example.onlineshop.domain.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WelcomeBackViewModel @Inject constructor(
  private val repository: DataBaseRepository
) : ViewModel() {

  private val _listUser = MutableLiveData<List<User>>()
  var listUser: LiveData<List<User>> = _listUser

  init {
    getAccounts()
  }

  private fun getAccounts() {
    viewModelScope.launch(Dispatchers.IO) {
      _listUser.postValue(repository.allUser())
    }
  }

  fun searchUser(list: List<User>, login: String): User? {
    return repository.searchUser(list, login)
  }
}