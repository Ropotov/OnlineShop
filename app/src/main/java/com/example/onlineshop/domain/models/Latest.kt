package com.example.onlineshop.domain.models

data class LatestItem(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
): ListItem {
    override val id: Long = hashCode().toLong()

}
data class LatestList(
    val latest: List<LatestItem>
): ListItem {
    override val id: Long = hashCode().toLong()
}