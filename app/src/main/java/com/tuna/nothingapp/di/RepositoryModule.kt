package com.tuna.nothingapp.di

import com.tuna.nothingapp.data.repository.CurrentLocationRepository
import com.tuna.nothingapp.data.repository.SearchLocationRepository
import com.tuna.nothingapp.data.repository.WeatherRepository
import com.tuna.nothingapp.data.repository.impl.CurrentLocationRepositoryImpl
import com.tuna.nothingapp.data.repository.impl.SearchLocationRepositoryImpl
import com.tuna.nothingapp.data.repository.impl.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindWeatherRepository(
        myRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    abstract fun bindSearchLocationRepository(
        myRepositoryImpl: SearchLocationRepositoryImpl
    ): SearchLocationRepository

    @Binds
    abstract fun bindCurrentLocationRepository(
        myRepositoryImpl: CurrentLocationRepositoryImpl
    ): CurrentLocationRepository
}
