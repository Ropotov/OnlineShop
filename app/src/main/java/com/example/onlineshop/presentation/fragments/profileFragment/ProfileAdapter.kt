package com.example.onlineshop.presentation.fragments.profileFragment

import com.example.onlineshop.domain.models.ListItem
import com.example.onlineshop.domain.models.ProfileMenuItem
import com.example.onlineshop.presentation.MainAdapterDelegates.profileMenuItemDelegate
import com.example.onlineshop.presentation.fragments.page1.ContentDiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ProfileAdapter() :
  AsyncListDifferDelegationAdapter<ListItem>(ContentDiffUtil()) {

  var itemClickListener: ((ProfileMenuItem) -> Unit)? = null

  init {

    delegatesManager
      .addDelegate(profileMenuItemDelegate(itemClickListener))
  }
}