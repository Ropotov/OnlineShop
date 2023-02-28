package com.example.onlineshop.domain

import com.example.onlineshop.domain.models.ListItem
import com.example.onlineshop.domain.models.ProfileMenuItem

interface AppRepository {
    suspend fun getListContent(): List<ListItem>
    fun getProfileMenuItem(): List<ProfileMenuItem>
}