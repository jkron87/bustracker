package com.example.jkron.bustracker.dagger

import com.example.jkron.bustracker.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent{

    fun inject(target: MainActivity)
}