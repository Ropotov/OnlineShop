package com.example.onlineshop.presentation.fragments.page1

import androidx.recyclerview.widget.DiffUtil
import com.example.onlineshop.domain.models.CategoryItem
import com.example.onlineshop.domain.models.FlashSale
import com.example.onlineshop.domain.models.FlashSaleX

class FlashSaleDiffCallBack : DiffUtil.ItemCallback<FlashSaleX>() {

    override fun areItemsTheSame(oldItem: FlashSaleX, newItem: FlashSaleX): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: FlashSaleX, newItem: FlashSaleX): Boolean {
        return oldItem == newItem
    }
}