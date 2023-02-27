package com.example.onlineshop.presentation.fragments.page1

import com.example.onlineshop.domain.models.ListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ContentAdapter : AsyncListDifferDelegationAdapter<ListItem>(ContentDiffUtil()) {
    init {
        delegatesManager.addDelegate(
            MainAdapterDelegates.horizontalDelegate
        )
    }
}