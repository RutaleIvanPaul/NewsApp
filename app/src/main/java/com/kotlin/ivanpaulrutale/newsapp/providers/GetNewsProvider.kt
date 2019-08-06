package com.kotlin.ivanpaulrutale.newsapp.providers

import android.app.Activity
import com.kotlin.ivanpaulrutale.newsapp.adapters.CustomAdapter

private val newsDataProvider: NewsDataProvider = NewsDataProvider()

val customAdapter = CustomAdapter()



fun getNews(activity:Activity,country:String){
    newsDataProvider.getNews(country,{ newsResult ->
        customAdapter.newsList.clear()
        customAdapter.newsList.addAll(newsResult.articles)
        activity?.runOnUiThread{
            customAdapter.notifyDataSetChanged()
        }
    })
}