package com.example.onlineshop.domain.useCases

import com.example.onlineshop.domain.AppRepository
import com.example.onlineshop.domain.models.CategoryItem

class GetCategoriesListUseCase(private val repository: AppRepository) {

    fun getCategoriesList(): List<CategoryItem> {
        return repository.getCategoriesList()
    }
}