package com.example.onlineshop.presentation.fragments.page1


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlineshop.databinding.SaleItemBinding
import com.example.onlineshop.domain.models.FlashSaleX

class FlashSaleAdapter : ListAdapter<FlashSaleX, FlashSaleViewHolder>(FlashSaleDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val binding = SaleItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FlashSaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val flashSalePosition = getItem(position)
        holder.bind(flashSalePosition)
    }
}