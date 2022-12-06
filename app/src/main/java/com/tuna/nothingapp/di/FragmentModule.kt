package com.tuna.nothingapp.di

import com.tuna.nothingapp.navigation.Navigator
import com.tuna.nothingapp.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class FragmentModule {
    @Binds
    abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
}