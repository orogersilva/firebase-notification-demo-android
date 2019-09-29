package com.orogersilva.firebasenotificationdemo.services

import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class DemoFirebaseMessagingService : FirebaseMessagingService() {

    companion object {

        val NEW_DEVICE_TOKEN_ACTION = "com.orogersilva.firebasenotificationdemo.NEW_DEVICE_TOKEN_ACTION"
        val NEW_DEVICE_TOKEN_EXTRA = "com.orogersilva.firebasenotificationdemo.NEW_DEVICE_TOKEN_EXTRA"

        val NEW_MESSAGE_RECEIVED_ACTION = "com.orogersilva.firebasenotificationdemo.NEW_MESSAGE_RECEIVED_ACTION"
        val NEW_MESSAGE_RECEIVED_EXTRA = "com.orogersilva.firebasenotificationdemo.NEW_MESSAGE_RECEIVED_EXTRA"
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

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        remoteMessage.notification?.body?.let { message ->

            val receivedMessageIntent = Intent(NEW_MESSAGE_RECEIVED_ACTION)

            receivedMessageIntent.putExtra(NEW_MESSAGE_RECEIVED_EXTRA, message)

            deviceTokenBroadcastManager.sendBroadcast(receivedMessageIntent)
        }
    }
}