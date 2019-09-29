package com.orogersilva.firebasenotificationdemo.repositories

import kotlinx.coroutines.Deferred
import retrofit2.Response

interface MainRepository {

    fun sendDeviceRegistrationToken(token: String): Deferred<Response<Int>>
}