package com.example.onlineshop.presentation.fragments.profileFragment

import com.example.onlineshop.domain.models.ListItem
import com.example.onlineshop.presentation.fragments.page1.ContentDiffUtil
import com.example.onlineshop.presentation.MainAdapterDelegates.profileMenuItemDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ProfileAdapter : AsyncListDifferDelegationAdapter<ListItem>(ContentDiffUtil()) {
  init {
    delegatesManager
      .addDelegate(profileMenuItemDelegate())
  }
}