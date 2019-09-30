package com.orogersilva.firebasenotificationdemo.models

import com.google.gson.annotations.SerializedName

data class DeviceTokenBody(
    @SerializedName("token") val deviceToken: String
)