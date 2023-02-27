package com.example.onlineshop.domain.models

data class HorizontalListItem(
    val title: String,
    val btnViewAll: String = "View all",
    val list: List<ListItem>
): ListItem {
    override val id: Long = title.hashCode().toLong()
}
