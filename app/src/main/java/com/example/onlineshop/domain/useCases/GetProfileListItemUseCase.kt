package com.example.onlineshop.domain.useCases

import com.example.onlineshop.data.AppRepositoryImpl
import com.example.onlineshop.domain.models.ProfileMenuItem

class GetProfileListItemUseCase( private val repository: AppRepositoryImpl) {

    fun getProfileList():List<ProfileMenuItem>{
        return repository.getProfileMenuItem()
    }
}