package com.example.onlineshop.domain

import com.example.onlineshop.domain.models.User

interface DataBaseRepository {
  suspend fun allUser(): List<User>
  suspend fun addAccount(user: User)
  suspend fun deleteAccount(user: User)
  fun searchUser(list:List<User>, login:String): User?
}
