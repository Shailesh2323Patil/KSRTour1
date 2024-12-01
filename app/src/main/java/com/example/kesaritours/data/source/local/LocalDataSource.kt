package com.example.kesaritours.data.source.local

import com.example.kesaritours.data.local.dao.ToursDao
import com.example.kesaritours.data.local.entity.ToursEntity
import com.example.kesaritours.data.source.DataSource
import com.example.kesaritours.util.DiskExecutor

class LocalDataSource(
    private val executor : DiskExecutor,
    private val tourDao : ToursDao
) : DataSource.Local {

    override suspend fun insertTourInformation(data : List<ToursEntity>) : LongArray{
        tourDao.deleteTourInfo()
        return tourDao.insertTourInfo(data)
    }

    override suspend fun getTourInformation(): List<ToursEntity> {
        try {
            var data = tourDao.getToursInfo()
            return data
        }
        catch (exception: Exception) {
            exception.printStackTrace()
        }

        return arrayListOf()
    }
}