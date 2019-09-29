package com.orogersilva.firebasenotificationdemo.data

import kotlinx.coroutines.Deferred
import retrofit2.Response

interface MainDataSource {

    interface Remote {

        fun sendDeviceRegistrationToken(token: String): Deferred<Response<Int>>
    }
}