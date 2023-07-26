package com.example.kesaritours.data.repository

import com.example.kesaritours.data.local.dao.ToursDao
import com.example.kesaritours.data.remote.ToursApi
import com.example.kesaritours.domain.model.Tours
import com.example.kesaritours.domain.repository.ToursInfoRepository
import com.example.kesaritours.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException


class ToursInfoRepositoryImpl(
    private val api: ToursApi,
    private val dao: ToursDao
) : ToursInfoRepository {

    override fun getToursInfo(): Flow<Resource<List<Tours>>> = flow {
        emit(Resource.Loading())

        val toursInfo: List<Tours> = dao.getToursInfo().map { it.toToursModel() }
        emit(Resource.Success(data = toursInfo))

        try {
            val remoteData = api.getToursInfo()
            dao.deleteTourInfo()
            dao.insertTourInfo(remoteData.map { it.toToursEntity() })
        }
        catch (exception : HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = null
                )
            )
        }
        catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.!",
                    data = null
                )
            )
        }

        val newToursInfo = dao.getToursInfo().map { it.toToursModel() }
        emit(Resource.Success(data = newToursInfo))
    }
}