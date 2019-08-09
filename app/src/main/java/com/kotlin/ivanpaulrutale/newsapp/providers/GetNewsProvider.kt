package com.kotlin.ivanpaulrutale.newsapp.providers

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.kotlin.ivanpaulrutale.newsapp.adapters.CustomAdapter
import com.kotlin.ivanpaulrutale.newsapp.models.Article
import com.kotlin.ivanpaulrutale.newsapp.models.Source
import com.kotlin.ivanpaulrutale.newsapp.views.FragmentTemplate

private val newsDataProvider: NewsDataProvider = NewsDataProvider()

val customAdapter = CustomAdapter()


fun getNews(activity:Activity,country:String){

    val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    val isConnected = activeNetwork?.isConnected()

    if (isConnected != null){
        newsDataProvider.getNews(country,{ newsResult ->
            customAdapter.newsList.clear()
            customAdapter.newsList.addAll(newsResult.articles)
            activity?.runOnUiThread{
                customAdapter.notifyDataSetChanged()
            }
        })
    }
    else{
        val article_no_internet = Article(
            Source("1","NewsApp"),
            "NewsApp",
            "No Internet Connection",
            "There is no Internet Connection Currently, " +
                    "Please check your connection and reload or visit the Saved and Shared tabs",
            "____",
            "R.drawable.no_internet",
            "NewsApp"
        )
        customAdapter.newsList.clear()
        customAdapter.newsList.addAll(arrayListOf(article_no_internet))
        activity?.runOnUiThread{
            customAdapter.notifyDataSetChanged()
        }
    }
}