package com.example.jkron.bustracker.api

import com.example.jkron.bustracker.model.RoutesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface Bustime {
    companion object {
        const val BUSTIME_BASE_URL = "http://rt.theride.org"
    }

    @GET("bustime/api/v3/getroutes?&format=json")
    fun routes(@Query("key")apiKey : String): Observable<RoutesResponse>

}