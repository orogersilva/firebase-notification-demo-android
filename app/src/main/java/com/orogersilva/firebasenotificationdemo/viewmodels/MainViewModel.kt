package com.orogersilva.firebasenotificationdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.orogersilva.firebasenotificationdemo.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun sendDeviceRegistrationToken(token: String) {

        GlobalScope.launch(Dispatchers.Main) {

            try {

                val response = mainRepository.sendDeviceRegistrationToken(token).await()

                if (response.isSuccessful) {

                    response.body()?.let { res ->


                    }

                } else {


                }

            } catch (e: Exception) {


            }
        }
    }
}