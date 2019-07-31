package com.kotlin.ivanpaulrutale.newsapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter
    (val newsList: ArrayList<News>, val context: Context): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.list_item,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news:News = newsList[position]
        holder.textView.text = news.headline

        holder.itemView.setOnClickListener{view ->
            val intent = Intent(view.context, NewsDetails::class.java)
            intent.putExtra("news_headline", news.headline)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById(R.id.headlineTextView) as TextView
    }
}