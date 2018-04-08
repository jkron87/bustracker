package com.example.jkron.bustracker.model

import com.google.gson.annotations.SerializedName

class RoutesResponse {
    @SerializedName("bustime-response")
    var bustimeResponse: BustimeResponse? = null

    inner class BustimeResponse {
        var routes: ArrayList<Route>? = null
    }

    inner class Route {
        @SerializedName("rt")
        var route: String? = null
        @SerializedName("rtnm")
        var routeName: String? = null
    }

}