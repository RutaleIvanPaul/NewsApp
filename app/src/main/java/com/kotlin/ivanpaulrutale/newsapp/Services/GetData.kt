package com.kotlin.ivanpaulrutale.newsapp.Services

import com.google.gson.GsonBuilder
import com.kotlin.ivanpaulrutale.newsapp.Article
import com.kotlin.ivanpaulrutale.newsapp.BASE_URL
import com.kotlin.ivanpaulrutale.newsapp.BuildConfig
import com.kotlin.ivanpaulrutale.newsapp.NewsReport
import okhttp3.*
import java.io.IOException
import java.util.ArrayList

fun fetchJSON(country:String): ArrayList<Article> {
    val url = BASE_URL +"top-headlines?country="+country+"&apiKey="+BuildConfig.Api_Key
    val request = Request.Builder()
        .url(url)
        .build()

    val client = OkHttpClient()
    var newsArticles: ArrayList<Article> = arrayListOf()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("Failed To Execute!!!!")
        }

        override fun onResponse(call: Call, response: Response) {
            val body = response.body()?.string()
            println(body)
            val gson = GsonBuilder().create()
            val news = gson.fromJson(body, NewsReport::class.java)

            newsArticles.addAll(news.articles)

        }

    })
    Thread.sleep(2000)
    return newsArticles

}