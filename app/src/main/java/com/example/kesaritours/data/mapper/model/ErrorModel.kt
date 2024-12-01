package com.example.kesaritours.data.mapper.model

/**
 * Default Error that Comes from Server if Something goes Wrong with a Repository Call
 * */
data class ErrorModel(
    val message: String?,
    val code: Int?,
    @Transient var errorStatus: ErrorStatus
) {
    constructor(errorStatus: ErrorStatus) : this(null, null, errorStatus)
}