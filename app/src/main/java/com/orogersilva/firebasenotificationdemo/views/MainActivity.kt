package com.orogersilva.firebasenotificationdemo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.firebase.iid.FirebaseInstanceId
import com.orogersilva.firebasenotificationdemo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isGooglePlayServicesAvailable()) {

            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        val token = task.result?.token

                        Log.d("MainActivity", "Token -> " + token)
                    }
                }
        }
    }

    override fun onResume() {

        super.onResume()

        if (isGooglePlayServicesAvailable()) {

            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        val token = task.result?.token

                        Log.d("MainActivity", "Token -> " + token)
                    }
                }
        }
    }

    private fun isGooglePlayServicesAvailable(): Boolean {

        val googleApiAvailability = GoogleApiAvailability.getInstance()

        val status = googleApiAvailability.isGooglePlayServicesAvailable(this)

        if (status != ConnectionResult.SUCCESS) {

            if (googleApiAvailability.isUserResolvableError(status)) {
                googleApiAvailability.getErrorDialog(this, status, 2404).show()
            }

            return false
        }

        return true
    }
}
