package com.example.kesaritours.domain.repository

import com.example.kesaritours.domain.model.Tours
import com.example.kesaritours.util.Resource
import kotlinx.coroutines.flow.Flow

interface ToursInfoRepository {
    fun getToursInfo() : Flow<Resource<List<Tours>>>
}