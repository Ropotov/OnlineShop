package com.example.onlineshop.domain.useCases

import com.example.onlineshop.data.AppRepositoryImpl
import com.example.onlineshop.domain.models.ListItem

class GetListContentUseCase(private val repository: AppRepositoryImpl) {

    suspend fun getConteList(): List<ListItem> {
        return repository.getListContent()
    }
}