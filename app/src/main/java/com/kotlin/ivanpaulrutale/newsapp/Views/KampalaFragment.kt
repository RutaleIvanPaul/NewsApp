package com.kotlin.ivanpaulrutale.newsapp.Views


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ivanpaulrutale.newsapp.*
import com.kotlin.ivanpaulrutale.newsapp.Services.fetchJSON



/**
 * A simple [Fragment] subclass.
 *
 */
class KampalaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_news, container, false)
        // Inflate the layout for this fragment

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)

        val linearLayoutManager = LinearLayoutManager(activity)

        recyclerView?.layoutManager = linearLayoutManager
        val customAdapter = CustomAdapter(fetchJSON("ug"), context!!)
        recyclerView?.adapter = customAdapter

        return view
    }


}
