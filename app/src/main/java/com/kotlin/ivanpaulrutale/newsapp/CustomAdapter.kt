package com.kotlin.ivanpaulrutale.newsapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.ArrayList

class CustomAdapter(val newsList: ArrayList<Article>, val context: Context): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.list_item,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news:Article = newsList[position]
        holder.textView.text = news.title

        holder.itemView.setOnClickListener{view ->
            val intent = Intent(view.context, NewsDetails::class.java)
            intent.putExtra("news_headline", news.title)
            intent.putExtra("publish_date", news.publishedAt)
            intent.putExtra("source", news.source.name)
            intent.putExtra("author", news.author)
            intent.putExtra("source_url", news.url)
            intent.putExtra("description", news.description)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById(R.id.headlineTextView) as TextView
    }
}