package com.example.onlineshop.domain.useCases

import com.example.onlineshop.data.repository.AppRepositoryImpl
import com.example.onlineshop.domain.models.ListItem
import javax.inject.Inject

class GetListContentUseCase @Inject constructor(
  private val repository: AppRepositoryImpl
) {
  suspend operator fun invoke() = repository.getListContent()
}