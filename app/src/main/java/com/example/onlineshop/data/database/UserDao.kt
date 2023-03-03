package com.example.onlineshop.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.onlineshop.domain.models.User

@Dao
interface UserDao {

  @Query(value = "SELECT * FROM database")
  fun allUser(): List<User>

  @Insert
  fun createAccount(user: User)

  @Delete
  fun deleteAccount(user: User)
}