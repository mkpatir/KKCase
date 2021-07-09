package com.mkpatir.kkcase.api

import com.mkpatir.kkcase.api.models.DriverDetailResponse
import com.mkpatir.kkcase.api.models.DriverResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getDrivers(): Flow<DriverResponse>

    fun getDriverDetail(id: Int): Flow<DriverDetailResponse>

}