package com.example.onlineshop.data

import com.example.onlineshop.R
import com.example.onlineshop.data.api.RetrofitInstance
import com.example.onlineshop.domain.AppRepository
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.LatestList

class AppRepositoryImpl() : AppRepository {

    override fun getCategoriesList(): List<CategoryItem> {
        return listOf(
            CategoryItem("Phones", R.drawable.phones),
            CategoryItem("Headphones", R.drawable.headphones),
            CategoryItem("Games", R.drawable.games),
            CategoryItem("Cars", R.drawable.cars),
            CategoryItem("Furniture", R.drawable.furniture),
            CategoryItem("Kids", R.drawable.kids),
        )
    }

    override suspend fun getLatestList(): LatestList {
        return RetrofitInstance.api.getLatestList()
    }

    override suspend fun getFlashSaleList(): FlashSale {
        return  RetrofitInstance.api.getFlashSaleList()
    }
}