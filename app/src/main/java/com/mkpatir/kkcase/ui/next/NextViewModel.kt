package com.mkpatir.kkcase.ui.next

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mkpatir.kkcase.api.AppRepository
import com.mkpatir.kkcase.api.models.DriverDetailResponse
import com.mkpatir.kkcase.cache.DBManager
import com.mkpatir.kkcase.internal.helpers.SharedPrefHelper
import com.mkpatir.kkcase.ui.base.BaseViewModel

class NextViewModel(
    private val appRepository: AppRepository,
    private val sharedPrefHelper: SharedPrefHelper,
    private val dbManager: DBManager?
): BaseViewModel() {

    private val _driverDetailLiveData = MutableLiveData<DriverDetailResponse>()
    val driverDetailLiveData: LiveData<DriverDetailResponse>
        get() = _driverDetailLiveData

    fun getDriverDetail(id: Int){
        callService(appRepository.getDriverDetail(id)){
            _driverDetailLiveData.value = it
        }
    }

}