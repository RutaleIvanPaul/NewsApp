package com.kotlin.ivanpaulrutale.newsapp.Views


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ivanpaulrutale.newsapp.CustomAdapter
import com.kotlin.ivanpaulrutale.newsapp.News
import com.kotlin.ivanpaulrutale.newsapp.R
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SharedFragment : Fragment() {

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

        val news = ArrayList<News>()

        news.add(News("Sharing"))
        news.add(News("All"))
        news.add(News("Freaking"))
        news.add(News("Day"))

        val customAdapter = CustomAdapter()

        recyclerView.adapter = customAdapter

        return view
    }


}