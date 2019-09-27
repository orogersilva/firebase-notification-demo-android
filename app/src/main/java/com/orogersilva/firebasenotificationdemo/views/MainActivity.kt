package com.orogersilva.firebasenotificationdemo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.orogersilva.firebasenotificationdemo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    val token = task.result?.token

                    Log.d("MainActivity", "Token -> " + token)
                }
            }
    }

    override fun onResume() {

        super.onResume()
    }
}
