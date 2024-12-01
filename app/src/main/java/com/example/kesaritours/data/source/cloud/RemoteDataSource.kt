package com.example.kesaritours.data.source.cloud

import com.example.kesaritours.data.remote.ToursApi
import com.example.kesaritours.data.remote.dto.ToursDto
import com.example.kesaritours.data.source.DataSource

class RemoteDataSource(private val api: ToursApi) : DataSource.Remote {
    override suspend fun getToursInfo(): List<ToursDto> {
        return api.getToursInfo()
    }
}