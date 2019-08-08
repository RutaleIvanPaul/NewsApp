package com.kotlin.ivanpaulrutale.newsapp.views


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ivanpaulrutale.newsapp.R
import com.kotlin.ivanpaulrutale.newsapp.providers.customAdapter
import com.kotlin.ivanpaulrutale.newsapp.providers.getNews


/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentTemplate : Fragment() {

    var country:String ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_news, container, false)
        // Inflate the layout for this fragment
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val linearLayoutManager = LinearLayoutManager(activity)

        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = customAdapter

        getNews(activity as Activity,country!!)
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getString("country")?.let {
            country = it
        }
    }

    companion object{
        fun newInstance(country:String) = FragmentTemplate().apply {
            arguments = Bundle().apply {
                putString("country",country)
            }
        }
    }


}
