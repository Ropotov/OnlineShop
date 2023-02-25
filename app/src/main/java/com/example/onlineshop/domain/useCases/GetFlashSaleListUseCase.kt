package com.example.onlineshop.domain.useCases

import com.example.onlineshop.data.AppRepositoryImpl
import com.example.onlineshop.domain.models.FlashSale

class GetFlashSaleListUseCase(private val repository: AppRepositoryImpl) {

    suspend fun getFlashSaleList(): FlashSale {
        return repository.getFlashSaleList()
    }
}