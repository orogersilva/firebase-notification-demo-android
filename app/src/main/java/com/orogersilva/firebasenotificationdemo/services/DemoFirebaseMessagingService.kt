package com.orogersilva.firebasenotificationdemo.services

import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService

class DemoFirebaseMessagingService : FirebaseMessagingService() {

    companion object {

        val NEW_DEVICE_TOKEN_ACTION = "com.orogersilva.firebasenotificationdemo.NEW_DEVICE_TOKEN_ACTION"

        val NEW_DEVICE_TOKEN_EXTRA = "com.orogersilva.firebasenotificationdemo.NEW_DEVICE_TOKEN_EXTRA"
    }

    private lateinit var deviceTokenBroadcastManager: LocalBroadcastManager

    override fun onCreate() {

        super.onCreate()

        deviceTokenBroadcastManager = LocalBroadcastManager.getInstance(this)
    }

    override fun onNewToken(newToken: String) {

        val deviceTokenIntent = Intent(NEW_DEVICE_TOKEN_ACTION)

        deviceTokenIntent.putExtra(NEW_DEVICE_TOKEN_EXTRA, newToken)

        deviceTokenBroadcastManager.sendBroadcast(deviceTokenIntent)
    }
}