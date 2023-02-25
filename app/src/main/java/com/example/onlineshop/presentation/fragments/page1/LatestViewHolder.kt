package com.example.onlineshop.presentation.fragments.page1

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshop.databinding.LatestItemBinding
import com.example.onlineshop.domain.models.LatestItem

class LatestViewHolder(private val binding: LatestItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: LatestItem) {
        with(binding) {
            tvLatestName.text = position.name
            tvLatestCategory.text = position.category
            tvLatestPrice.text = "$" + position.price
            Glide.with(ivLatestItem).load(position.image_url).into(ivLatestItem)
        }
    }
}