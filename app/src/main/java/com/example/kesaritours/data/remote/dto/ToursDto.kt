package com.example.kesaritours.data.remote.dto

import com.example.kesaritours.data.local.entity.ToursEntity
import com.google.gson.annotations.SerializedName

data class ToursDto(
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("TOURCODE") var TOURCODE: String? = null,
    @SerializedName("TOURNAME") var TOURNAME: String? = null,
    @SerializedName("F_TYPE") var FTYPE: String? = null,
    @SerializedName("F_MEALTYPE") var FMEALTYPE: String? = null,
    @SerializedName("F_SPLMEAL1") var FSPLMEAL1: String? = null,
    @SerializedName("F_TOPPING1") var FTOPPING1: String? = null,
    @SerializedName("F_HTLCATG") var FHTLCATG: String? = null,
    @SerializedName("F_BUSTYPE") var FBUSTYPE: String? = null,
    @SerializedName("TOUR_ID") var TOURID: String? = null,
    @SerializedName("TM_ZONE") var TMZONE: String? = null,
    @SerializedName("SUGG_AIRLN") var SUGGAIRLN: String? = null,
    @SerializedName("F_VALERT1") var FVALERT1: String? = null,
    @SerializedName("F_VALERT2") var FVALERT2: String? = null,
    @SerializedName("F_VALERT3") var FVALERT3: String? = null,
    @SerializedName("images") var images: ArrayList<String> = arrayListOf(),
    @SerializedName("tourzoneimages") var tourzoneimages: String? = null,
    @SerializedName("app_tourzoneimages") var appTourzoneimages: String? = null,
    @SerializedName("tourcode_allimages") var tourcodeAllimages: ArrayList<TourcodeAllimages> = arrayListOf(),
    @SerializedName("tour_usp") var tourUsp: TourUsp? = TourUsp(),
    @SerializedName("TM_ID") var TMID: String? = null,
    @SerializedName("TOURMAS0") var TOURMAS0: ArrayList<TOURMAS> = arrayListOf(),
    @SerializedName("generated_NETCOST") var generatedNETCOST: String? = null,
    @SerializedName("generated_TM_DT1") var generatedTMDT1: String? = null,
    @SerializedName("generated_COST_2DAY") var generatedCOST2DAY: String? = null,
    @SerializedName("generated_DISC_2DAY") var generatedDISC2DAY: String? = null,
    @SerializedName("generated_COST_INR") var generatedCOSTINR: String? = null,
    @SerializedName("generated_COST_FRX") var generatedCOSTFRX: String? = null,
    @SerializedName("generated_COST_CUR") var generatedCOSTCUR: String? = null,
    @SerializedName("journeyCategory") var journeyCategory: String? = null,
    @SerializedName("bestSeller") var bestSeller: String? = null,
    @SerializedName("JL_COST") var JLCOST: String? = null,
    @SerializedName("currency") var currency: String? = null,
    @SerializedName("additionalDiscount") var additionalDiscount: AdditionalDiscount? = AdditionalDiscount(),
    @SerializedName("ITINERARY_COUNT") var ITINERARYCOUNT: String? = null,
    @SerializedName("visit") var visit: String? = null,
    @SerializedName("total_country") var totalCountry: String? = null,
    @SerializedName("total_city") var totalCity: String? = null,
    @SerializedName("start_city") var startCity: String? = null,
    @SerializedName("end_city") var endCity: String? = null,
    @SerializedName("start_country") var startCountry: String? = null,
    @SerializedName("end_country") var endCountry: String? = null,
    @SerializedName("tour_series_info") var tourSeriesInfo: TourSeriesInfo? = TourSeriesInfo(),
    @SerializedName("Departures") var Departures: ArrayList<String> = arrayListOf()
) {
    data class TourcodeAllimages(
        @SerializedName("path") var path: String? = null,
        @SerializedName("title") var title: String? = null
    )

    data class TourUsp(
        @SerializedName("0") var A0: String? = null,
        @SerializedName("1") var A1: String? = null,
        @SerializedName("2") var A2: String? = null,
        @SerializedName("3") var A3: String? = null,
        @SerializedName("4") var A4: String? = null,
        @SerializedName("5") var A5: String? = null,
        @SerializedName("6") var A6: String? = null,
        @SerializedName("7") var A7: String? = null,
        @SerializedName("8") var A8: String? = null
    )

    data class TOURMAS(
        @SerializedName("seatStatus") var seatStatus: String? = null,
        @SerializedName("generated_NETCOST") var generatedNETCOST: String? = null,
        @SerializedName("bonanza_tourseries") var bonanzaTourseries: String? = null,
        @SerializedName("bonanza_TMDT2") var bonanzaTMDT2: String? = null,
        @SerializedName("bonanza_TMDT1") var bonanzaTMDT1: String? = null,
        @SerializedName("bonanza_SING") var bonanzaSING: String? = null,
        @SerializedName("bonanza_CURCODE") var bonanzaCURCODE: String? = null,
        @SerializedName("bonanza_CH2") var bonanzaCH2: String? = null,
        @SerializedName("bonanza_CH1WB") var bonanzaCH1WB: String? = null,
        @SerializedName("bonanza_CH1") var bonanzaCH1: String? = null,
        @SerializedName("bonanza_BKGDT2") var bonanzaBKGDT2: String? = null,
        @SerializedName("bonanza_BKGDT1") var bonanzaBKGDT1: String? = null,
        @SerializedName("bonanza_AD3") var bonanzaAD3: String? = null,
        @SerializedName("bonanza_AD") var bonanzaAD: String? = null,
        @SerializedName("JL_COST") var JLCOST: String? = null,
        @SerializedName("DISC_2DAY") var DISC2DAY: String? = null,
        @SerializedName("LST_2DEAL") var LST2DEAL: String? = null,
        @SerializedName("COST_2DAY") var COST2DAY: String? = null,
        @SerializedName("TM_HUB") var TMHUB: String? = null,
        @SerializedName("TM_FINCATG") var TMFINCATG: String? = null,
        @SerializedName("TM_PAX") var TMPAX: String? = null,
        @SerializedName("TM_PAXMKT") var TMPAXMKT: String? = null,
        @SerializedName("TM_DAYS") var TMDAYS: String? = null,
        @SerializedName("TM_DT2") var TMDT2: String? = null,
        @SerializedName("TM_DT1") var TMDT1: String? = null,
        @SerializedName("TM_ID") var TMID: String? = null,
        @SerializedName("TM_ZONE") var TMZONE: String? = null,
        @SerializedName("TM_TCD") var TMTCD: String? = null,
        @SerializedName("currency") var currency: String? = null
    )

    data class AdditionalDiscount(
        @SerializedName("name") var name: String? = null,
        @SerializedName("amount") var amount: String? = null
    )

    data class TourSeriesInfo(
        @SerializedName("cities_covered") var citiesCovered: ArrayList<CitiesCovered> = arrayListOf(),
        @SerializedName("low_season_months") var lowSeasonMonths: ArrayList<String> = arrayListOf(),
        @SerializedName("high_season_months") var highSeasonMonths: ArrayList<String> = arrayListOf(),
        @SerializedName("super_peak_season_months") var superPeakSeasonMonths: ArrayList<String> = arrayListOf(),
        @SerializedName("off_season_months") var offSeasonMonths: ArrayList<String> = arrayListOf(),
        @SerializedName("festival_months") var festivalMonths: ArrayList<String> = arrayListOf(),
        @SerializedName("countries_covered") var countriesCovered: ArrayList<String> = arrayListOf(),
        @SerializedName("airlines_included") var airlinesIncluded: ArrayList<String> = arrayListOf(),
        @SerializedName("journey_by_road") var journeyByRoad: String? = null,
        @SerializedName("tour_route") var tourRoute: String? = null,
        @SerializedName("airline_route") var airlineRoute: String? = null,
        @SerializedName("things_to_carry") var thingsToCarry: String? = null,
        @SerializedName("precautions") var precautions: String? = null,
        @SerializedName("competitor_agent_used") var competitorAgentUsed: String? = null,
        @SerializedName("competitor_company") var competitorCompany: String? = null,
        @SerializedName("price_to") var priceTo: String? = null,
        @SerializedName("price_from") var priceFrom: String? = null,
        @SerializedName("total_groups_yearly") var totalGroupsYearly: String? = null,
        @SerializedName("hotel_suggested") var hotelSuggested: String? = null,
        @SerializedName("transport_agent_suggested") var transportAgentSuggested: String? = null,
        @SerializedName("guest_potential_city") var guestPotentialCity: String? = null,
        @SerializedName("guest_type") var guestType: String? = null,
        @SerializedName("tour_operator") var tourOperator: String? = null,
        @SerializedName("total_nights") var totalNights: String? = null,
        @SerializedName("total_city") var totalCity: String? = null,
        @SerializedName("total_country") var totalCountry: String? = null,
        @SerializedName("journey_hours") var journeyHours: String? = null,
        @SerializedName("end_city_point") var endCityPoint: String? = null,
        @SerializedName("start_city_point") var startCityPoint: String? = null,
        @SerializedName("static_map_image") var staticMapImage: String? = null,
        @SerializedName("continents") var continents: String? = null,
        @SerializedName("end_country") var endCountry: String? = null,
        @SerializedName("start_country") var startCountry: String? = null
    )

    data class CitiesCovered(
        @SerializedName("iso_code_2") var isoCode2: String? = null,
        @SerializedName("country_name") var countryName: String? = null,
        @SerializedName("city_name") var cityName: String? = null,
        @SerializedName("number_of_nights") var numberOfNights: String? = null,
        @SerializedName("_id") var Id: String? = null
    )

    fun toToursEntity() : ToursEntity {
        return ToursEntity(
            tmDays = "1",
            images = images,
            tmZone = TMZONE,
            bestSeller = "bestSeller",
            tourName = TOURNAME,
            startCountry = startCountry,
            generatedCost2Day = generatedCOST2DAY,
            startCity = startCity,
            endCity = endCity,
            totalCity = totalCity,
            journeyCategory = journeyCategory,
            generatedDisc2Day = generatedDISC2DAY,
            generatedNetCost = generatedNETCOST,
            tourCode = TOURCODE
        )
    }
}