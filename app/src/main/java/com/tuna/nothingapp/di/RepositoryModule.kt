package com.tuna.nothingapp.di

import com.tuna.nothingapp.data.repository.LocationRepository
import com.tuna.nothingapp.data.repository.WeatherRepository
import com.tuna.nothingapp.data.repository.impl.LocationRepositoryImpl
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
    abstract fun bindLocationRepository(
        myRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository
}
