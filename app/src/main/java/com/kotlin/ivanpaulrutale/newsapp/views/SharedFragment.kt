package com.kotlin.ivanpaulrutale.newsapp.views


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ivanpaulrutale.newsapp.models.Article_DB
import com.kotlin.ivanpaulrutale.newsapp.R
import com.kotlin.ivanpaulrutale.newsapp.adapters.Adapter_DB
import com.kotlin.ivanpaulrutale.newsapp.database.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import java.util.ArrayList

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

        val news = ArrayList<Article_DB>()
        news.addAll(activity?.database?.use {
            select("Shared_Article"
            ).parseList(classParser<Article_DB>())
        } as ArrayList<Article_DB>)

        val adapter_DB = Adapter_DB()
        adapter_DB.newsList.addAll(news)
        recyclerView.adapter = adapter_DB

        activeFragment = "SharedFragment"

        return view
    }


}
