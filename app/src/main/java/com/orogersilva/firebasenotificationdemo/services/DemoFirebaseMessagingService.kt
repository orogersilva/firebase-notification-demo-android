package com.orogersilva.firebasenotificationdemo.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class DemoFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(newToken: String) {

        Log.d("DemoFirebaseMsgService", "New token -> $newToken")
    }
}