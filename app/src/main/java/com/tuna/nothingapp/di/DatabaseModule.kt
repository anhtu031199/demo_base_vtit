package com.tuna.nothingapp.di

import android.content.Context
import androidx.room.Room
import com.tuna.nothingapp.data.local.dao.LocationDAO
import com.tuna.nothingapp.data.local.dao.WeatherDAO
import com.tuna.nothingapp.data.local.database.TodayioDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideWeatherDAO(todayioDatabase: TodayioDatabase): WeatherDAO =
        todayioDatabase.weatherDao()

    @Singleton
    @Provides
    fun provideLocationDAO(todayioDatabase: TodayioDatabase): LocationDAO =
        todayioDatabase.locationDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): TodayioDatabase {
        return Room.databaseBuilder(
            appContext,
            TodayioDatabase::class.java,
            "todayio"
        ).allowMainThreadQueries().build()
    }
}