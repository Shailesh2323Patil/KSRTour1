package com.example.kesaritours.data.remote

import com.example.kesaritours.data.remote.dto.ToursDto
import retrofit2.http.GET

interface ToursApi {
    @GET("route/inventory/getTourPackageDataApp/0/Andaman/0")
    suspend fun getToursInfo() : List<ToursDto>
}