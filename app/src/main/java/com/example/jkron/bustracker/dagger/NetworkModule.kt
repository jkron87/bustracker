package com.example.jkron.bustracker.dagger

import com.example.jkron.bustracker.api.BustimeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideBustimeService() = BustimeService()
}