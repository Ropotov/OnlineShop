package com.example.onlineshop.presentation.fragments.page1

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshop.databinding.ItemCategoryBinding
import com.example.onlineshop.databinding.SaleItemBinding
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.FlashSaleX

class FlashSaleViewHolder(private val binding: SaleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: FlashSaleX) {
        with(binding) {
            tvSaleName.text = position.name
            tvSaleCategory.text = position.category
            tvSalePrice.text = "$" + position.price
            Glide.with(ivSaleItem).load(position.image_url).into(ivSaleItem)
        }
    }
}