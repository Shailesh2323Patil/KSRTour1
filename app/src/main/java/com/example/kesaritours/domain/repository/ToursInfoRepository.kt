package com.example.kesaritours.domain.repository

import com.example.kesaritours.domain.model.Tours

interface ToursInfoRepository {
    suspend fun getToursInfo() : List<Tours>
}