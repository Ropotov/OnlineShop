package com.example.onlineshop.presentation.fragments.page1

import androidx.recyclerview.widget.DiffUtil
import com.example.onlineshop.domain.models.LatestItem

class LatestDiffCallBack : DiffUtil.ItemCallback<LatestItem>() {

    override fun areItemsTheSame(oldItem: LatestItem, newItem: LatestItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: LatestItem, newItem: LatestItem): Boolean {
        return oldItem == newItem
    }
}