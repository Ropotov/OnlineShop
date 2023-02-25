package com.example.onlineshop.presentation.fragments.page1


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlineshop.databinding.LatestItemBinding
import com.example.onlineshop.domain.models.LatestItem

class LatestAdapter : ListAdapter<LatestItem, LatestViewHolder>(LatestDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding = LatestItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val latestPosition = getItem(position)
        holder.bind(latestPosition)
    }
}