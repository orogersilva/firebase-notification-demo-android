package com.orogersilva.firebasenotificationdemo.network.endpoint

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST

interface FirebaseNotificationDemoApiClient {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    ) @POST("") fun sendDeviceRegistrationToken(token: String): Deferred<Response<Int>>
}