package com.example.onlineshop.domain.useCases

import com.example.onlineshop.data.AppRepositoryImpl
import com.example.onlineshop.domain.models.LatestList

class GetLatestListUseCase(private val repository: AppRepositoryImpl) {

    suspend fun getLatestList(): LatestList {
        return repository.getLatestList()
    }
}