package com.orogersilva.firebasenotificationdemo.data.remote

import com.orogersilva.firebasenotificationdemo.data.MainDataSource
import com.orogersilva.firebasenotificationdemo.models.DeviceTokenBody
import com.orogersilva.firebasenotificationdemo.network.endpoint.FirebaseNotificationDemoApiClient
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MainRemoteDataSource(
    private val firebaseNotificationDemoApiClient: FirebaseNotificationDemoApiClient)
    : MainDataSource.Remote {

    override fun sendDeviceRegistrationToken(token: String): Deferred<Response<Int>> {

        val deviceTokenBody = DeviceTokenBody(token)

        return firebaseNotificationDemoApiClient.sendDeviceRegistrationToken(deviceTokenBody)
    }
}