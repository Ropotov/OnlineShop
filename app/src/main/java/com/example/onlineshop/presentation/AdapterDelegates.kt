package com.example.onlineshop.presentation

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.onlineshop.R
import com.example.onlineshop.databinding.*
import com.example.onlineshop.domain.models.*
import com.example.onlineshop.presentation.fragments.page1.ListHorizontalAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainAdapterDelegates {

  fun horizontalDelegate() =
    adapterDelegateViewBinding<HorizontalListItem, ListItem, HorizontalListItemBinding>({ inflater, container ->
      HorizontalListItemBinding.inflate(
        inflater,
        container,
        false
      )
    }
    ) {
      val adapter = ListHorizontalAdapter()
      binding.recyclerView.adapter = adapter
      bind {
        with(binding) {
          tvTitle.text = item.title
          tvViewAll.text = item.btnViewAll
          adapter.items = item.list
        }
      }
    }


  fun categoryItemDelegate() =
    adapterDelegateViewBinding<CategoryItem, ListItem, ItemCategoryBinding>({ inflater, container ->
      ItemCategoryBinding.inflate(inflater, container, false)
    }
    ) {
      bind {
        with(binding) {
          tvCategoryName.text = item.name
          ivCategoryIcon.setImageResource(item.resId)
        }
      }
    }

  @SuppressLint("SetTextI18n")
  fun latestItemDelegate() =
    adapterDelegateViewBinding<LatestItem, ListItem, LatestItemBinding>({ inflater, container ->
      LatestItemBinding.inflate(inflater, container, false)
    }
    ) {
      bind {
        with(binding) {
          tvLatestName.text = item.name
          tvLatestCategory.text = item.category
          tvLatestPrice.text = "$" + item.price.toString()
          Glide.with(ivLatestItem).load(item.image_url).into(ivLatestItem)
        }
      }
    }

  @SuppressLint("SetTextI18n")
  fun flashSaleItemDelegate() =
    adapterDelegateViewBinding<FlashSaleX, ListItem, SaleItemBinding>({ inflater, container ->
      SaleItemBinding.inflate(inflater, container, false)
    }
    ) {
      bind {
        with(binding) {
          tvSaleName.text = item.name
          tvSaleCategory.text = item.category
          tvSalePrice.text = "$" + item.price.toString()
          tvSalePercent.text = item.discount.toString() + "% off"
          Glide.with(ivSaleItem).load(item.image_url).into(ivSaleItem)
        }
      }
    }

  fun profileMenuItemDelegate(itemClickedListener: ((ProfileMenuItem) -> Unit)?) =
    adapterDelegateViewBinding<ProfileMenuItem, ListItem, ProfileMenuItemBinding>({ inflater, container ->
      ProfileMenuItemBinding.inflate(inflater, container, false)
    }
    ) {
      binding.root.setOnClickListener {
        itemClickedListener?.invoke(item)
      }
      bind {
        with(binding) {
          tvMenuItemName.text = item.name
          menuIcon.setImageResource(item.resId)
          when (item.endTv) {
            is String -> tvBack.text = item.endTv.toString()
            is Int -> tvBack.setCompoundDrawablesWithIntrinsicBounds(
              null, null, getDrawable(R.drawable.next_button), null
            )
          }
        }
      }
    }
}

