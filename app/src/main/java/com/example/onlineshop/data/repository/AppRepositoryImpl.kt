package com.example.onlineshop.data.repository

import com.example.onlineshop.R
import com.example.onlineshop.data.api.ApiService
import com.example.onlineshop.domain.AppRepository
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.HorizontalListItem
import com.example.onlineshop.domain.models.ListItem
import com.example.onlineshop.domain.models.ProfileMenuItem
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
  private val apiService: ApiService
) : AppRepository {

  override suspend fun getListContent(): List<ListItem> {
    return listOf(
      HorizontalListItem(
        title = "Latest",
        list = apiService.getLatestList().latest
      ),
      HorizontalListItem(
        title = "Flash sale",
        list = apiService.getFlashSaleList().flash_sale
      ),
      HorizontalListItem(
        title = "Brands",
        list = apiService.getLatestList().latest
      ),
    )
  }

  override fun getCategoryItem(): List<CategoryItem> {
    return listOf(
      CategoryItem("Phones", R.drawable.phones),
      CategoryItem("Headphones", R.drawable.headphones),
      CategoryItem("Games", R.drawable.games),
      CategoryItem("Cars", R.drawable.cars),
      CategoryItem("Furniture", R.drawable.furniture),
      CategoryItem("Kids", R.drawable.kids),
    )
  }

  override fun getProfileMenuItem(): List<ProfileMenuItem> {
    return listOf(
      ProfileMenuItem(
        name = "Trade Store",
        resId = R.drawable.credit_card,
        endTv = R.drawable.next_button
      ),
      ProfileMenuItem(
        name = "Payment methods",
        resId = R.drawable.credit_card,
        endTv = R.drawable.next_button
      ),
      ProfileMenuItem(
        name = "Balance",
        resId = R.drawable.credit_card,
        endTv = R.drawable.next_button
      ),
      ProfileMenuItem(
        name = "Trade history",
        resId = R.drawable.credit_card,
        endTv = "$1996"
      ),
      ProfileMenuItem(
        name = "Restore purchase",
        resId = R.drawable.restore_menu_item,
        endTv = R.drawable.next_button
      ),
      ProfileMenuItem(
        name = "Help",
        resId = R.drawable.help_menu_item,
      ),
      ProfileMenuItem(
        name = "Log out",
        resId = R.drawable.log_out_menu_item,
      ),
    )
  }
}