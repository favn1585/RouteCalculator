package com.uav.box.network.di

import com.uav.box.network.client.FlightDataClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideFlightDataClient(retrofit: Retrofit): FlightDataClient {
        return retrofit.create(FlightDataClient::class.java)
    }

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com"
    }
}