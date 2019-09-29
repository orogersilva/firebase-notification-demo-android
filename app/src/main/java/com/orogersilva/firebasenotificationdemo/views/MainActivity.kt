package com.orogersilva.firebasenotificationdemo.views

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.firebase.iid.FirebaseInstanceId
import com.orogersilva.firebasenotificationdemo.R
import com.orogersilva.firebasenotificationdemo.services.DemoFirebaseMessagingService
import com.orogersilva.firebasenotificationdemo.viewmodels.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {

        super.onStart()

        LocalBroadcastManager.getInstance(this).registerReceiver(newDeviceTokenReceiver,
            IntentFilter(DemoFirebaseMessagingService.NEW_DEVICE_TOKEN_ACTION))
    }

    override fun onStop() {

        super.onStop()

        LocalBroadcastManager.getInstance(this).unregisterReceiver(newDeviceTokenReceiver)
    }

    private val newDeviceTokenReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {

            val newDeviceToken = intent
                .getStringExtra(DemoFirebaseMessagingService.NEW_DEVICE_TOKEN_EXTRA)

            newDeviceToken?.let { nDeviceToken ->

                // mainViewModel.sendDeviceRegistrationToken(nDeviceToken)
            }
        }
    }
}
