package com.example.kesaritours.data.mapper.model


/**
* Various Error Status to know what happened if something goes wrong with a repository Call
* */
enum class ErrorStatus {
    /**
     * Error in connecting to repository (Server or Database)
     * */
    NO_CONNECTION,
    /**
     * Error in getting value (JSON Error, Server Error, etc)
     * */
    BAD_RESPONSE,
    /**
     * TIME OUT Error
     * */
    TIMEOUT,
    /**
     * No Data Available in Repository
     * */
    EMPTY_RESPONSE,
    /**
     * An Unexpected Error
     * */
    NOT_DEFINED,
    /**
     * Bad Credentials
     * */
    UNAUTHORIZED
}