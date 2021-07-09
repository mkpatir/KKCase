package com.mkpatir.kkcase.api

import com.mkpatir.kkcase.api.models.DriverDetailResponse
import com.mkpatir.kkcase.api.models.DriverResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl(private val appService: AppService): AppRepository {

    override fun getDrivers(): Flow<DriverResponse> = flow { emit(appService.getDrivers()) }

    override fun getDriverDetail(id: Int): Flow<DriverDetailResponse> = flow { emit(appService.getDriverDetail(id)) }

}