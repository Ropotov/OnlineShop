package com.example.onlineshop.domain

import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.LatestList

interface AppRepository {

    fun getCategoriesList(): List<CategoryItem>

    suspend fun getLatestList(): LatestList

    suspend fun getFlashSaleList(): FlashSale
}