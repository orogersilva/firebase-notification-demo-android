package com.orogersilva.firebasenotificationdemo.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class FirebaseMessagingDemoService : FirebaseMessagingService() {

    override fun onNewToken(newToken: String) {

        Log.d("FirebaseMsgDemoService", "New token -> $newToken")
    }
}