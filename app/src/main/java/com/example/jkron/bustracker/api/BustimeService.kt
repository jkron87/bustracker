package com.example.jkron.bustracker.api

import com.example.jkron.bustracker.BuildConfig
import com.example.jkron.bustracker.model.RoutesResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class BustimeService {

    val api: Bustime by lazy {
        Retrofit.Builder()
                .baseUrl(Bustime.BUSTIME_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Bustime::class.java)
    }

    fun fetchRoutes(): Observable<RoutesResponse>? {
        return api.routes(BuildConfig.BUSTIME_API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }
}
