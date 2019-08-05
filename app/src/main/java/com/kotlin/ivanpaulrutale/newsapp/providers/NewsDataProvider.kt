package com.kotlin.ivanpaulrutale.newsapp.providers

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.kotlin.ivanpaulrutale.newsapp.BASE_URL
import com.kotlin.ivanpaulrutale.newsapp.BuildConfig
import com.kotlin.ivanpaulrutale.newsapp.NewsReport
import java.io.Reader
import java.lang.Exception

class NewsDataProvider {

    fun getNews(country:String,responseHandler:(result:NewsReport) -> Unit){
        val url = BASE_URL +"everything?q="+country+"&apiKey="+ BuildConfig.ApiSecKey
        url.httpGet().responseObject(NewsDataDeserializer()){_,response,result ->
            if (response.statusCode != 200){
                throw Exception("Unable to get News!!!")
            }
            val (data,_) = result
            responseHandler.invoke(data as @kotlin.ParameterName(name = "result") NewsReport)
        }
    }
    class NewsDataDeserializer():ResponseDeserializable<NewsReport>{

        override fun deserialize(reader: Reader): NewsReport? {
            return Gson().fromJson(reader,NewsReport::class.java)
        }
    }
}