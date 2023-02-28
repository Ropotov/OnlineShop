package com.example.onlineshop.presentation.fragments.page1

import com.example.onlineshop.domain.models.ListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ListHorizontalAdapter : AsyncListDifferDelegationAdapter<ListItem>(ContentDiffUtil()) {
    init {
        delegatesManager
            .addDelegate(MainAdapterDelegates.categoryItemDelegate())
            .addDelegate(MainAdapterDelegates.latestItemDelegate())
            .addDelegate(MainAdapterDelegates.flashSaleItemDelegate())
    }
}