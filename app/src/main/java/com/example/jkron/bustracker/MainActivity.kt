package com.example.jkron.bustracker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.jkron.bustracker.api.BustimeService
import com.example.jkron.bustracker.application.BusTimeApplication
import com.example.jkron.bustracker.model.RoutesResponse
import com.example.jkron.bustracker.utils.bindView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bustimeService: BustimeService

    @Inject
    lateinit var routeAdapter: RouteAdapter

    val recyclerView: RecyclerView? by bindView(R.id.recycler_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as BusTimeApplication).appComponent.inject(this)

//        val routeAdapter = RouteAdapter(this)

        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = routeAdapter

        bustimeService.fetchRoutes()?.subscribe(object : Observer<RoutesResponse> {
            override fun onComplete() {
                Log.d(MainActivity::class.java.name, "finished making fetch routes request")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: RoutesResponse) {
                routeAdapter.swap(t.bustimeResponse?.routes)
            }

            override fun onError(e: Throwable) {
                Log.e(MainActivity::class.java.name, e.message)
                Toast.makeText(this@MainActivity, "Oops! No routes founds", Toast.LENGTH_SHORT).show()
            }

        })

    }

    override fun onResume() {
        super.onResume()

        // TODO
    }

}
