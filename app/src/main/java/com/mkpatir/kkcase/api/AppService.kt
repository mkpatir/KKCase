package com.mkpatir.kkcase.api

import com.mkpatir.kkcase.api.models.DriverDetailResponse
import com.mkpatir.kkcase.api.models.DriverResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AppService {

    @GET("oguzayan/kuka/drivers")
    suspend fun getDrivers(): DriverResponse

    @GET("oguzayan/kuka/driverDetail/{id}")
    suspend fun getDriverDetail(@Path("id") id: Int): DriverDetailResponse

}