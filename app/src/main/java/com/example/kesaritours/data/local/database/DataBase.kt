package com.example.kesaritours.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kesaritours.data.local.dao.ToursDao
import com.example.kesaritours.data.local.entity.ToursEntity
import com.example.kesaritours.data.local.util.Converters

@Database(
    entities = [ToursEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {
    abstract val toursDao: ToursDao
}