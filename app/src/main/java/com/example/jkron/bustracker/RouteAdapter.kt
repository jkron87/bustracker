package com.example.jkron.bustracker

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jkron.bustracker.model.RoutesResponse
import java.util.ArrayList


class RouteAdapter internal constructor(context: Context) : RecyclerView.Adapter<RouteAdapter.ViewHolder>(){

    private var routes: ArrayList<RoutesResponse.Route> = ArrayList()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: ItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recycler_view_row, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val route = routes[position]
        holder.myTextView.text = route.route
    }


    override fun getItemCount(): Int {
        return routes.size
    }


    internal fun getItem(id: Int): String {
        return routes[id].route.toString()
    }


    internal fun setClickListener(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener
    }


    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun swap(list: ArrayList<RoutesResponse.Route>?) {
        if (list != null) {
            routes = list
            notifyDataSetChanged()
        }

    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var myTextView: TextView

        init {
            myTextView = itemView.findViewById(R.id.stop)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }
}
