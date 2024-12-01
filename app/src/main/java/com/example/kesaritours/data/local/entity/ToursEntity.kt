package com.example.kesaritours.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kesaritours.domain.model.Tours

@Entity
data class ToursEntity(
    @PrimaryKey val id:Int? = null,
    @ColumnInfo(name = "tm_days") var tmDays: String? = null,
    @ColumnInfo(name = "images") var images: List<String> = arrayListOf(),
    @ColumnInfo(name = "tm_zone") var tmZone: String? = null,
    @ColumnInfo(name = "best_seller") var bestSeller: String? = null,
    @ColumnInfo(name = "tour_name") var tourName: String? = null,
    @ColumnInfo(name = "start_country") var startCountry: String? = null,
    @ColumnInfo(name = "generated_cost_2_day") var generatedCost2Day: String? = null,
    @ColumnInfo(name = "start_city") var startCity: String? = null,
    @ColumnInfo(name = "end_city") var endCity: String? = null,
    @ColumnInfo(name = "total_city") var totalCity: String? = null,
    @ColumnInfo(name = "journey_category") var journeyCategory: String? = null,
    @ColumnInfo(name = "generated_disc_2_day") var generatedDisc2Day: String? = null,
    @ColumnInfo(name = "generated_net_cost") var generatedNetCost: String? = null,
    @ColumnInfo(name = "tour_code") var tourCode: String? = null,
) {
    fun toToursModel() : Tours {
        return Tours(
            tmDays = tmDays,
            images = images,
            tmZone = tmZone,
            bestSeller = bestSeller,
            tourName = tourName,
            startCountry = startCountry,
            generatedCost2Day = generatedCost2Day,
            startCity = startCity,
            endCity = endCity,
            totalCity = totalCity,
            journeyCategory = journeyCategory,
            generatedDisc2Day = generatedDisc2Day,
            generatedNetCost = generatedNetCost,
            tourCode = tourCode
        )
    }
}