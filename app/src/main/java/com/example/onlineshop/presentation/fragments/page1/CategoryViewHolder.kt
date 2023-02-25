package com.example.onlineshop.presentation.fragments.page1

import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ItemCategoryBinding
import com.example.onlineshop.domain.models.CategoryItem

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: CategoryItem) {
        with(binding) {
            tvCategoryName.text = position.name
            ivCategoryIcon.setImageResource(position.resId)
        }
    }
}