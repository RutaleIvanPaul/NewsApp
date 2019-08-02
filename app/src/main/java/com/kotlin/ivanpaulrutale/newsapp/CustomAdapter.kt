package com.kotlin.ivanpaulrutale.newsapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val newsList: ArrayList<Article> = arrayListOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.list_item,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news:Article = newsList[position]
        holder.titleTextView.text = news.title
        holder.descriptionTextView.text = news.description

        holder.itemView.setOnClickListener{view ->
            val intent = Intent(view.context, NewsDetails::class.java)
            intent.putExtra("news_headline", news.title)
            view.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleTextView = itemView.findViewById(R.id.headlineTextView) as TextView
        val descriptionTextView = itemView.findViewById(R.id.descriptionTextView) as TextView
    }
}