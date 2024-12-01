package com.example.kesaritours.data.repository

import com.example.kesaritours.data.source.DataSource
import com.example.kesaritours.domain.model.Tours
import com.example.kesaritours.domain.repository.ToursInfoRepository


class ToursInfoRepositoryImpl(
    private val remoteDataSource: DataSource.Remote ,
    private val localDataSource: DataSource.Local ,
    private val cacheDataSource: DataSource.Cache
) : ToursInfoRepository {
    override suspend fun getToursInfo(): List<Tours> {
        var apiData = remoteDataSource.getToursInfo()
        
        var readyDataForInsertion = apiData.map { it.toToursEntity() }
        var longArray = localDataSource.insertTourInformation(readyDataForInsertion)

        var fetchFromLocal = localDataSource.getTourInformation()

        return fetchFromLocal.map { it.toToursModel() }
    }
}