package com.example.kesaritours.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kesaritours.data.local.entity.ToursEntity

@Dao
interface ToursDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourInfo(tours: List<ToursEntity>) : LongArray

    @Query("DELETE FROM ToursEntity")
    suspend fun deleteTourInfo()

    @Query("SELECT * FROM ToursEntity")
    suspend fun getToursInfo() : List<ToursEntity>

}