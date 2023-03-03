package com.example.onlineshop.presentation.fragments.page1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.repository.AppRepositoryImpl
import com.example.onlineshop.domain.models.ListItem
import com.example.onlineshop.domain.useCases.GetListContentUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class Page1ViewModel @Inject constructor(
  private val getListContentUseCase: GetListContentUseCase
): ViewModel() {

  var isLoading = MutableLiveData(true)

  private val _data = MutableLiveData<List<ListItem>>()
  val data: LiveData<List<ListItem>> = _data

  init {
    viewModelScope.launch {
      val items = getItems()
      _data.value = items
      isLoading.value = false
    }
  }

  private suspend fun getItems(): List<ListItem> {
    return getListContentUseCase.invoke()
  }
}