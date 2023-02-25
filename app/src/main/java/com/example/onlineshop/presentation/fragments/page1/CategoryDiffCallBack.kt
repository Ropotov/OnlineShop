package com.example.onlineshop.presentation.fragments.page1

import androidx.recyclerview.widget.DiffUtil
import com.example.onlineshop.domain.models.CategoryItem

class CategoryDiffCallBack : DiffUtil.ItemCallback<CategoryItem>() {
    override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }
}