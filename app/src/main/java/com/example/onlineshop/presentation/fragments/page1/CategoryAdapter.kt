package com.example.onlineshop.presentation.fragments.page1


import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlineshop.databinding.ItemCategoryBinding
import com.example.onlineshop.domain.models.CategoryItem

class CategoryAdapter : ListAdapter<CategoryItem, CategoryViewHolder>(CategoryDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryPosition = getItem(position)
        holder.bind(categoryPosition)
    }
}