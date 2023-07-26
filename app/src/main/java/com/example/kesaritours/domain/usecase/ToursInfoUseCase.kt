package com.example.kesaritours.domain.usecase

import com.example.kesaritours.domain.model.Tours
import com.example.kesaritours.domain.repository.ToursInfoRepository
import com.example.kesaritours.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToursInfoUseCase @Inject constructor(
    private val repository: ToursInfoRepository
) {
    operator fun invoke() : Flow<Resource<List<Tours>>> {
        return repository.getToursInfo()
    }
}