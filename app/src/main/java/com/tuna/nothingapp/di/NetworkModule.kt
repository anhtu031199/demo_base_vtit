package com.tuna.nothingapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tuna.nothingapp.BuildConfig
import com.tuna.nothingapp.data.remote.services.CurrentLocationService
import com.tuna.nothingapp.data.remote.services.SearchLocationService
import com.tuna.nothingapp.data.remote.services.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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
    fun provideSearchLocationService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): SearchLocationService = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_WEATHER_URL)
        .build()
        .create(SearchLocationService::class.java)

    @Singleton
    @Provides
    fun provideCurrentLocationService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): CurrentLocationService = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_WEATHER_URL)
        .build()
        .create(CurrentLocationService::class.java)

}