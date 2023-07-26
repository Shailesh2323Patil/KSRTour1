package com.example.kesaritours.domain.model

import com.google.gson.annotations.SerializedName

data class Tours(
    @SerializedName("TM_DAYS") var tmDays: Int? = null,
    @SerializedName("images") var images: List<String> = arrayListOf(),
    @SerializedName("TM_ZONE") var tmZone: String? = null,
    @SerializedName("bestSeller") var bestSeller: String? = null,
    @SerializedName("TOURNAME") var tourName: String? = null,
    @SerializedName("start_country") var startCountry: String? = null,
    @SerializedName("generated_COST_2DAY") var generatedCost2Day: Int? = null,
    @SerializedName("start_city") var startCity: String? = null,
    @SerializedName("end_city") var endCity: String? = null,
    @SerializedName("total_city") var totalCity: Int? = null,
    @SerializedName("journeyCategory") var journeyCategory: String? = null,
    @SerializedName("generated_DISC_2DAY") var generatedDisc2Day: Int? = null,
    @SerializedName("generated_NETCOST") var generatedNetCost: Int? = null,
    @SerializedName("TOURCODE") var tourCode: String? = null,
)