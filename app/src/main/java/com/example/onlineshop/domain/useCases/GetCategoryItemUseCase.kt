package com.example.onlineshop.domain.useCases

import com.example.onlineshop.domain.AppRepository
import javax.inject.Inject

class GetCategoryItemUseCase @Inject constructor(
  private val repository: AppRepository
) {
  operator fun invoke() = repository.getCategoryItem()
}