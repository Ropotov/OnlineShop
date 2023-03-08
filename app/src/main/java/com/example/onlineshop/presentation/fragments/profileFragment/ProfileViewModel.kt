package com.example.onlineshop.presentation.fragments.profileFragment

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.domain.DataBaseRepository
import com.example.onlineshop.domain.models.ProfileMenuItem
import com.example.onlineshop.domain.models.User
import com.example.onlineshop.domain.useCases.GetProfileListItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
  private val getProfileListItemUseCase: GetProfileListItemUseCase,
) : ViewModel() {

  private val _listProfileItem = MutableLiveData<List<ProfileMenuItem>>()
  val listProfileItem: LiveData<List<ProfileMenuItem>> = _listProfileItem

  init {
    getListProfileItem()
  }

  private fun getListProfileItem() {
    _listProfileItem.value = getProfileListItemUseCase.invoke()
  }
}