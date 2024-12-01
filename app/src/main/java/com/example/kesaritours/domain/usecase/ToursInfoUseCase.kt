package com.example.kesaritours.domain.usecase

import com.example.kesaritours.data.mapper.CloudErrorMapper
import com.example.kesaritours.data.usecase.base.UseCase
import com.example.kesaritours.domain.model.Tours
import com.example.kesaritours.domain.repository.ToursInfoRepository
import javax.inject.Inject

class ToursInfoUseCase @Inject constructor(
    errorUtil: CloudErrorMapper ,
    var tokenRepository: ToursInfoRepository
) : UseCase<List<Tours>>(errorUtil) {
    override suspend fun executeOnBackground(): List<Tours> {
        return tokenRepository.getToursInfo()
    }
}