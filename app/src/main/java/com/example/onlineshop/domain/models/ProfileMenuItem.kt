package com.example.onlineshop.domain.models

data class ProfileMenuItem(
    val name: String,
    val resId: Int,
    val endTv: Any? = null
) : ListItem {
    override val id: Long = name.hashCode().toLong()
}
