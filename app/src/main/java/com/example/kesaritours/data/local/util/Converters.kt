package com.example.kesaritours.data.local.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val gsonParser: GsonParser
) {
    @TypeConverter
    fun fromList(json: String): List<String> {
        return gsonParser.fromJson<List<String>>(
            json = json,
            type = object : TypeToken<List<String>> () {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toList(list: List<String>): String {
        return gsonParser.toJson(
            list,
            type = object : TypeToken<List<String>> () {}.type
        ) ?: "[]"
    }
}