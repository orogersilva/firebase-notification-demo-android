package com.orogersilva.firebasenotificationdemo.repositories.impl

import com.orogersilva.firebasenotificationdemo.data.MainDataSource
import com.orogersilva.firebasenotificationdemo.repositories.MainRepository
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MainDataRepository(private val mainRemoteDataSource: MainDataSource.Remote) : MainRepository {

    override fun sendDeviceRegistrationToken(token: String): Deferred<Response<Int>> =
        mainRemoteDataSource.sendDeviceRegistrationToken(token)
}