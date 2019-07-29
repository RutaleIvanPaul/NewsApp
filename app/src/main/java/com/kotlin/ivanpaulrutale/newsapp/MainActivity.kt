package com.kotlin.ivanpaulrutale.newsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val news = ArrayList<News>()
        news.add(News("Winning"))
        news.add(News("All"))
        news.add(News("Freaking"))
        news.add(News("Day"))

        val adapter = CustomAdapter(news)
        recyclerView.adapter = adapter
    }
}
