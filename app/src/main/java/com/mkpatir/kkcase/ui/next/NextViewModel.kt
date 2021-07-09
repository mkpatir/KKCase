package com.mkpatir.kkcase.ui.next

import com.mkpatir.kkcase.api.AppRepository
import com.mkpatir.kkcase.cache.DBManager
import com.mkpatir.kkcase.internal.helpers.SharedPrefHelper
import com.mkpatir.kkcase.ui.base.BaseViewModel

class NextViewModel(
    private val appRepository: AppRepository,
    private val sharedPrefHelper: SharedPrefHelper,
    private val dbManager: DBManager?
): BaseViewModel() {

}