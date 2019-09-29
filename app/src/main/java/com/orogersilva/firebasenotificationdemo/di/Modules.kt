package com.orogersilva.firebasenotificationdemo.di

import com.orogersilva.firebasenotificationdemo.BuildConfig
import com.orogersilva.firebasenotificationdemo.data.MainDataSource
import com.orogersilva.firebasenotificationdemo.data.remote.MainRemoteDataSource
import com.orogersilva.firebasenotificationdemo.network.RestClient
import com.orogersilva.firebasenotificationdemo.network.endpoint.FirebaseNotificationDemoApiClient
import com.orogersilva.firebasenotificationdemo.repositories.MainRepository
import com.orogersilva.firebasenotificationdemo.repositories.impl.MainDataRepository
import com.orogersilva.firebasenotificationdemo.viewmodels.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val mainNetworkModule: Module = module {

    single { RestClient.getApiClient(
        serviceClass = FirebaseNotificationDemoApiClient::class.java,
        baseEndpoint = BuildConfig.BASE_API_URL
    ) }

    factory<MainDataSource.Remote> {
        MainRemoteDataSource(firebaseNotificationDemoApiClient = get())
    }
}

val mainRepositoryModule: Module = module {

    factory<MainRepository> {
        MainDataRepository(mainRemoteDataSource = get())
    }
}

val mainViewModelModule: Module = module {

    viewModel { MainViewModel(mainRepository = get()) }
}