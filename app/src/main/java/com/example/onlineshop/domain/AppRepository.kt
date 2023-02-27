package com.example.onlineshop.domain

import com.example.onlineshop.domain.models.ListItem

interface AppRepository {
    suspend fun getListContent(): List<ListItem>
}