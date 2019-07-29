package com.kotlin.ivanpaulrutale.newsapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter(val newsList: ArrayList<News>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.list_item,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val news:News = newsList[p1]
        p0?.textView.text = news.headline
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById(R.id.headlineTextView) as TextView
    }
}