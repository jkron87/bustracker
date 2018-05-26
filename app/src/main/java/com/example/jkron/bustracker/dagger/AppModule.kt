package com.example.jkron.bustracker.dagger

import android.app.Application
import android.content.Context
import com.example.jkron.bustracker.RouteAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideRouteAdapter(): RouteAdapter = RouteAdapter(app)

}