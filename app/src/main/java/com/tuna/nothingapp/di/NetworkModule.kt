package com.tuna.nothingapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tuna.nothingapp.BuildConfig
import com.tuna.nothingapp.data.remote.services.LocationService
import com.tuna.nothingapp.data.remote.services.WeatherService
import com.tuna.nothingapp.data.repository.WeatherRepository
import com.tuna.nothingapp.data.repository.impl.WeatherRepositoryImpl
import com.tuna.nothingapp.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideGsonConverter(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .apply {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()

    @Singleton
    @Provides
    fun provideWeatherService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): WeatherService = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_WEATHER_URL)
        .build()
        .create(WeatherService::class.java)

    @Singleton
    @Provides
    fun provideLocationService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): LocationService = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_LOCATION_URL)
        .build()
        .create(LocationService::class.java)

}