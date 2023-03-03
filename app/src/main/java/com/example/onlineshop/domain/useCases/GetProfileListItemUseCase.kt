package com.example.onlineshop.domain.useCases

import com.example.onlineshop.data.repository.AppRepositoryImpl
import javax.inject.Inject

class GetProfileListItemUseCase @Inject constructor(
  private val repository: AppRepositoryImpl
) {
  operator fun invoke() = repository.getProfileMenuItem()
}
