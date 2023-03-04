package com.example.onlineshop.presentation.fragments.page1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.repository.AppRepositoryImpl
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.ListItem
import com.example.onlineshop.domain.useCases.GetCategoryItemUseCase
import com.example.onlineshop.domain.useCases.GetListContentUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class Page1ViewModel @Inject constructor(
  private val getListContentUseCase: GetListContentUseCase,
  private val getCategoryItemUseCase: GetCategoryItemUseCase
): ViewModel() {

  var isLoading = MutableLiveData(true)

  private val _data = MutableLiveData<List<ListItem>>()
  val data: LiveData<List<ListItem>> = _data

  private val _category = MutableLiveData<List<CategoryItem>>()
  val category: LiveData<List<CategoryItem>> = _category

  init {
    viewModelScope.launch {
      _data.value = getItems()
      _category.value = getCategory()
      isLoading.value = false
    }
  }

  private suspend fun getItems(): List<ListItem> {
    return getListContentUseCase.invoke()
  }

  private fun getCategory(): List<CategoryItem>{
    return getCategoryItemUseCase()
  }
}