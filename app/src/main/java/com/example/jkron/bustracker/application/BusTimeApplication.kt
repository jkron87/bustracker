package com.example.jkron.bustracker.application

import android.app.Application
import com.example.jkron.bustracker.dagger.AppComponent
import com.example.jkron.bustracker.dagger.AppModule
import com.example.jkron.bustracker.dagger.DaggerAppComponent

class BusTimeApplication : Application() {

    lateinit var appComponent: AppComponent

    private fun initDagger(app: BusTimeApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }
}