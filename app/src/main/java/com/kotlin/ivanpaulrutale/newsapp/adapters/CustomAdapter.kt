package com.kotlin.ivanpaulrutale.newsapp.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.ivanpaulrutale.newsapp.models.Article
import com.kotlin.ivanpaulrutale.newsapp.R
import com.kotlin.ivanpaulrutale.newsapp.views.NewsDetails
import com.squareup.picasso.Picasso

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
        val news: Article = newsList[position]
        holder.titleTextView.text = news.title
        holder.descriptionTextView.text = news.description
        Picasso.with(holder.itemView.context).load(news.urlToImage).into(holder.imageView)

        holder.itemView.setOnClickListener{view ->
            val intent = Intent(view.context, NewsDetails::class.java)
            intent.putExtra("news_headline", news.title)
            intent.putExtra("news_description", news.description)
            intent.putExtra("publish_date", news.publishedAt)
            intent.putExtra("source", news.source.name)
            intent.putExtra("author", news.author)
            intent.putExtra("url", news.url)
            intent.putExtra("urlToImage", news.urlToImage)
            view.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleTextView = itemView.findViewById(R.id.headlineTextView) as TextView
        val descriptionTextView = itemView.findViewById(R.id.descriptionTextView) as TextView
        val imageView = itemView.findViewById<ImageView>(R.id.newsImage)!!
    }
}