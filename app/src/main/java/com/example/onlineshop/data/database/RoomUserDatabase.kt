package com.example.onlineshop.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onlineshop.domain.models.User

@Database(entities = [User::class], version = 1)
abstract class RoomUserDatabase : RoomDatabase() {

  abstract fun userDao(): UserDao

  companion object {
    private var db: RoomUserDatabase? = null

    @Synchronized
    fun getInstance(context: Context): RoomUserDatabase {
      return if (db == null) {
        db = Room.databaseBuilder(context, RoomUserDatabase::class.java, "dataBase")
          .build()
        db as RoomUserDatabase
      } else {
        db as RoomUserDatabase
      }
    }
  }
}