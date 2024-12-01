package com.example.kesaritours.presentation

import com.example.kesaritours.domain.model.Tours

data class ToursInfoState(
    val toursInfoItem: List<Tours> = emptyList()
)

data class LoadingInfoState(
    val isLoading: Boolean = false
)