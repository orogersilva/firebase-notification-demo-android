package com.orogersilva.firebasenotificationdemo

import android.app.Application
import com.orogersilva.firebasenotificationdemo.di.mainNetworkModule
import com.orogersilva.firebasenotificationdemo.di.mainRepositoryModule
import com.orogersilva.firebasenotificationdemo.di.mainViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FirebaseNotificationDemoApplication : Application() {

    override fun onCreate() {

        super.onCreate()

        // Initializing Koin modules...
        startKoin {

            androidContext(this@FirebaseNotificationDemoApplication)

            modules(listOf(
                mainNetworkModule,
                mainRepositoryModule,
                mainViewModelModule
            ))
        }
    }
}