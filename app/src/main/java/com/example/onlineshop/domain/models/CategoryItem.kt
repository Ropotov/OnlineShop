package com.example.onlineshop.domain.models

data class CategoryItem(
    val name: String,
    val resId: Int
) : ListItem {
    override val id: Long = hashCode().toLong()
}