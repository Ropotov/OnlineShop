package com.example.onlineshop.data.repository

import com.example.onlineshop.domain.models.User
import com.example.onlineshop.data.database.UserDao
import com.example.onlineshop.domain.DataBaseRepository
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(
  private val userDao: UserDao
) : DataBaseRepository {

  override suspend fun allUser(): List<User> {
    return userDao.allUser()
  }

  override suspend fun addAccount(user: User) {
    userDao.createAccount(user)
  }

  override suspend fun deleteAccount(user: User) {
    userDao.deleteAccount(user)
  }

  override fun searchUser(list: List<User>, login: String): User? {
    var user: User? = null
    for (i in list) {
      if (login == i.firstName) user = i
    }
    return user
  }
}