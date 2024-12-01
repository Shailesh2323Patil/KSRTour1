package com.example.kesaritours.data.mapper

import com.example.kesaritours.data.mapper.model.ErrorModel
import com.example.kesaritours.data.mapper.model.ErrorStatus
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class CloudErrorMapper @Inject constructor() {

    fun mapToDomainErrorException(throwable: Throwable?): ErrorModel {
        val errorModel: ErrorModel? = when (throwable) {
            is HttpException -> {
                if(throwable.code() == 401) {
                    ErrorModel(ErrorStatus.UNAUTHORIZED)
                } else {
                    getHttpError(throwable.response()!!.errorBody())
                }
            }

            is SocketTimeoutException -> {
                ErrorModel("TIME OUT!!", 0, ErrorStatus.TIMEOUT)
            }

            is IOException -> {
                ErrorModel("CHECK CONNECTION", 0, ErrorStatus.NO_CONNECTION)
            }

            is UnknownHostException -> {
                ErrorModel("CHECK CONNECTION", 0, ErrorStatus.NO_CONNECTION)
            }

            is Exception -> {
                ErrorModel("Something Went Wrong", 0, ErrorStatus.NO_CONNECTION)
            }

            else -> null
        }

        return errorModel!!
    }

    /**
     * Attempts to Parse http response body and get data from it
     * Retrofit Response Body
     * */
    private fun getHttpError(body: ResponseBody?): ErrorModel {
        return try {
            val result = body?.string()
            val json = Gson().fromJson(result, JsonObject::class.java)
            ErrorModel(json.toString(), 400, ErrorStatus.BAD_RESPONSE)
        }
        catch (exception: Throwable) {
            exception.printStackTrace()
            ErrorModel(ErrorStatus.NOT_DEFINED)
        }
    }
}