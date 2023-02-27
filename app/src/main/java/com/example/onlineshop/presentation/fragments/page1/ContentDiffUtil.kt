package com.example.onlineshop.presentation.fragments.page1

import com.example.onlineshop.domain.models.ListItem

class ContentDiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ListItem>(){
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.equals(newItem)
    }
}