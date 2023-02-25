package com.example.onlineshop.presentation.fragments.page1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.AppRepositoryImpl
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.LatestList
import com.example.onlineshop.domain.useCases.GetCategoriesListUseCase
import com.example.onlineshop.domain.useCases.GetFlashSaleListUseCase
import com.example.onlineshop.domain.useCases.GetLatestListUseCase
import kotlinx.coroutines.launch

class Page1ViewModel : ViewModel() {


    private val repository = AppRepositoryImpl()
    private val getCategoriesListUseCase = GetCategoriesListUseCase(repository)
    private val getLatestListUseCase = GetLatestListUseCase(repository)
    private val getFlashSaleListUseCase = GetFlashSaleListUseCase(repository)

    var isLoading = MutableLiveData(true)

    private val _categoriesList = MutableLiveData<List<CategoryItem>>()
    val categoriesList: LiveData<List<CategoryItem>> = _categoriesList

    private val _latestList = MutableLiveData<LatestList>()
    val latestList: LiveData<LatestList> = _latestList

    private val _flashSaleList = MutableLiveData<FlashSale>()
    val flashSaleList: LiveData<FlashSale> = _flashSaleList

    init {
        getCategoriesList()
        getContent()
    }

    private fun getCategoriesList() {
        _categoriesList.value = getCategoriesListUseCase.getCategoriesList()
    }

    private fun getContent() {
        viewModelScope.launch {
            _latestList.value = getLatestListUseCase.getLatestList()
            _flashSaleList.value = getFlashSaleListUseCase.getFlashSaleList()
            isLoading.value = false
        }
    }
}