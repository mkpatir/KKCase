package com.mkpatir.kkcase.api.models

import com.google.gson.annotations.SerializedName

data class DriverDetailResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("age") val age: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("team") val team: String?
)