package com.example.onlineshop.data

import com.example.onlineshop.R
import com.example.onlineshop.data.api.RetrofitInstance
import com.example.onlineshop.domain.AppRepository
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.HorizontalListItem
import com.example.onlineshop.domain.models.ListItem

class AppRepositoryImpl() : AppRepository {
    override suspend fun getListContent(): List<ListItem> {

        val categoryListItem = listOf(
            CategoryItem("Phones", R.drawable.phones),
            CategoryItem("Headphones", R.drawable.headphones),
            CategoryItem("Games", R.drawable.games),
            CategoryItem("Cars", R.drawable.cars),
            CategoryItem("Furniture", R.drawable.furniture),
            CategoryItem("Kids", R.drawable.kids),
        )
        val latestListItem = RetrofitInstance.api.getLatestList()
        val flashSaleListItem = RetrofitInstance.api.getFlashSaleList()

        return listOf(
            HorizontalListItem(
                title = "Categories",
                list = categoryListItem
            ),
            HorizontalListItem(
                title = "Latest",
                list = latestListItem.latest
            ),
            HorizontalListItem(
                title = "Flash sale",
                list = flashSaleListItem.flash_sale
            ),
            HorizontalListItem(
                title = "Brands",
                list = latestListItem.latest
            ),
        )
    }
}