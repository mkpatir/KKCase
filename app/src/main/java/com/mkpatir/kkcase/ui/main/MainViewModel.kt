package com.mkpatir.kkcase.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mkpatir.kkcase.api.AppRepository
import com.mkpatir.kkcase.api.models.DriverData
import com.mkpatir.kkcase.cache.DBManager
import com.mkpatir.kkcase.internal.helpers.SharedPrefHelper
import com.mkpatir.kkcase.ui.base.BaseViewModel

class MainViewModel(
    private val appRepository: AppRepository,
    private val sharedPrefHelper: SharedPrefHelper,
    private val dbManager: DBManager?
): BaseViewModel() {

    private val _driversLiveData = MutableLiveData<MutableList<DriverData>>()
    val driversLiveData: LiveData<MutableList<DriverData>>
        get() = _driversLiveData

    init {
        callService(appRepository.getDrivers()){ response ->
            response.items?.forEach { item ->
                item.isFavorite = isDriverFavorite(item)
            }
            _driversLiveData.value = response.items?.sortedWith(compareBy { it.point })?.reversed()?.toMutableList()
        }
    }

    fun addOrRemoveFavorite(data: DriverData) {
        if (data.isFavorite){
            dbManager?.favoritesDAO()?.removeFromFavorites(data.toFavoriteModel())
        }
        else {
            dbManager?.favoritesDAO()?.addToFavorites(data.toFavoriteModel())
        }
        val list = _driversLiveData.value
        _driversLiveData.value?.forEachIndexed { index, driverData ->
            if (data.id == driverData.id){
                list?.get(index)?.isFavorite = driverData.isFavorite.not()
            }
        }
        _driversLiveData.postValue(list)
    }

    fun sortDrivers(sort: Sort){
        when(sort){
            Sort.INCREASING -> _driversLiveData.value = _driversLiveData.value?.sortedWith(compareBy { it.point })?.toMutableList()
            Sort.DECREASING -> _driversLiveData.value = _driversLiveData.value?.sortedWith(compareBy { it.point })?.reversed()?.toMutableList()
        }
    }

    private fun getFavorites() = dbManager?.favoritesDAO()?.getFavorites()

    private fun isDriverFavorite(data: DriverData): Boolean{
        return getFavorites()?.contains(data.toFavoriteModel()) == true
    }

    enum class Sort {
        INCREASING,
        DECREASING
    }

}