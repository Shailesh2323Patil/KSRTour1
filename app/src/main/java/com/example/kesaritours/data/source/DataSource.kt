package com.example.kesaritours.data.source

import com.example.kesaritours.data.local.entity.ToursEntity
import com.example.kesaritours.data.remote.dto.ToursDto

interface DataSource {
    interface Remote {
        suspend fun getToursInfo() : List<ToursDto>
    }

    interface Local {
        suspend fun insertTourInformation(data : List<ToursEntity>) : LongArray
        suspend fun getTourInformation() : List<ToursEntity>
    }

    interface Cache {

    }
}