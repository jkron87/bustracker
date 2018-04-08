package com.example.jkron.bustracker.model

import com.google.gson.annotations.SerializedName

class StopsResponse {
    @SerializedName("bustime-response")
    var bustimeResponse: BustimeResponse? = null

    inner class BustimeResponse {
        var stops: ArrayList<Stop>? = null
    }

    inner class Stop {
        var stpid: String? = null
        var stpnm: String? = null
        var lat: String? = null
        var lon: String? = null
    }

}