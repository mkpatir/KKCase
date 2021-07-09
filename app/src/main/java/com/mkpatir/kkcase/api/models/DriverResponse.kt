package com.mkpatir.kkcase.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.mkpatir.kkcase.cache.models.FavoriteModel
import com.mkpatir.kkcase.internal.extension.orZero
import kotlinx.android.parcel.Parcelize

data class DriverResponse(
    @SerializedName("items") val items: ArrayList<DriverData>?
)

@Parcelize
data class DriverData(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("point") val point: Int?,
    var isFavorite: Boolean = false
) : Parcelable {

    fun toFavoriteModel() = FavoriteModel(
        id.orZero(),
        name.orEmpty(),
        point.orZero()
    )

}