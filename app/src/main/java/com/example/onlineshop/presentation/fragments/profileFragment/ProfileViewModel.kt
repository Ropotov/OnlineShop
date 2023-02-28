package com.example.onlineshop.presentation.fragments.profileFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.AppRepositoryImpl
import com.example.onlineshop.domain.models.ProfileMenuItem
import com.example.onlineshop.domain.useCases.GetProfileListItemUseCase

class ProfileViewModel : ViewModel() {

    private val repository = AppRepositoryImpl()
    private val getProfileListItemUseCase = GetProfileListItemUseCase(repository)

    private val _listProfileItem = MutableLiveData<List<ProfileMenuItem>>()
    val listProfileItem: LiveData<List<ProfileMenuItem>> = _listProfileItem

    init {
        getListProfileItem()
    }

    private fun getListProfileItem() {
        _listProfileItem.value = getProfileListItemUseCase.getProfileList()
    }

}