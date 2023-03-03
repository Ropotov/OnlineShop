package com.example.onlineshop.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "database",
  indices = [
    Index("firstName", unique = true)
  ]
)
data class User(
  @PrimaryKey var firstName: String,
  @ColumnInfo
  var lastName: String,
  @ColumnInfo
  var email: String,
  @ColumnInfo
  var password: String = lastName
)