package com.example.onlineshop.domain.models

data class LatestItem(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)
data class LatestList(
    val latest: List<LatestItem>
)