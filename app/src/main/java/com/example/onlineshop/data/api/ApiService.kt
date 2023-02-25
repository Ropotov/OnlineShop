package com.example.onlineshop.data.api

import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.LatestList
import retrofit2.http.GET

interface ApiService {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestList(): LatestList

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSaleList(): FlashSale
}