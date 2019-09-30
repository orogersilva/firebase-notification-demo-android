package com.orogersilva.firebasenotificationdemo.network.endpoint

import com.orogersilva.firebasenotificationdemo.models.DeviceTokenBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface FirebaseNotificationDemoApiClient {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    ) @POST("setToken") fun sendDeviceRegistrationToken(
        @Body deviceTokenBody: DeviceTokenBody
    ): Deferred<Response<Int>>
}