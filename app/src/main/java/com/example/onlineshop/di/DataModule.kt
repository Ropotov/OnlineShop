package com.example.onlineshop.di

import android.app.Application
import com.example.onlineshop.data.api.ApiService
import com.example.onlineshop.data.api.RetrofitInstance
import com.example.onlineshop.data.database.RoomUserDatabase
import com.example.onlineshop.data.database.UserDao
import com.example.onlineshop.data.repository.AppRepositoryImpl
import com.example.onlineshop.data.repository.DataBaseRepositoryImpl
import com.example.onlineshop.domain.AppRepository
import com.example.onlineshop.domain.DataBaseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

  @Binds
  fun bindAppRepository(impl: AppRepositoryImpl): AppRepository

  @Binds
  fun bindDataBaseRepository(impl: DataBaseRepositoryImpl): DataBaseRepository

  companion object {

    @Provides
    fun provideUserDao(application: Application): UserDao {
      return RoomUserDatabase.getInstance(application).userDao()
    }

    @Provides
    fun provideApiService(): ApiService {
      return RetrofitInstance.api
    }
  }
}