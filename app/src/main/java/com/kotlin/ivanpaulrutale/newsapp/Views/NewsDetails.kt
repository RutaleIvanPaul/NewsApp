package com.kotlin.ivanpaulrutale.newsapp.Views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.ivanpaulrutale.newsapp.R
import com.kotlin.ivanpaulrutale.newsapp.database.database
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_news_details.*
import org.jetbrains.anko.db.insert

class NewsDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        setSupportActionBar(toolbar)

        val news_headline = intent.getStringExtra("news_headline")
        val news_description = intent.getStringExtra("news_description")
        val publish_date = intent.getStringExtra("publish_date")
        val source = intent.getStringExtra("source")
        val author = intent.getStringExtra("author")
        val url = intent.getStringExtra("url")
        val urlToImage = intent.getStringExtra("urlToImage")
        val imageView = findViewById<ImageView>(R.id.newsImage)
        findViewById<TextView>(R.id.headlineTextView).text = news_headline
        findViewById<TextView>(R.id.descriptionTextView).text = news_description
        findViewById<TextView>(R.id.publishDateTextView).text = publish_date
        findViewById<TextView>(R.id.sourceTextView).text = source
        findViewById<TextView>(R.id.authorTextView).text = author
        findViewById<TextView>(R.id.sourceUrlTextView).text = url


        Picasso.with(imageView.context).load(urlToImage).into(imageView)

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Checkout this news:\n$url\nShared from NewsApp")
            type = "text/plain"
        }

        findViewById<Button>(R.id.ShareButton).setOnClickListener {
            startActivity(sendIntent)
        }

        findViewById<Button>(R.id.SaveButton).setOnClickListener {
            saveArticle(source,author,news_headline,news_description,url,urlToImage,publish_date)
        }

    }

    private fun saveArticle(source_name:String,author:String,title:String,description:String,url:String,urlToImage:String,publishedAt:String) {
        database.use {
            insert("Article",
                "source_name" to source_name,
                "author" to author,
                "title" to title,
                "description" to description,
                "url" to url,
                "urlToImage" to urlToImage,
                "publishedAt" to publishedAt
            )
        }
    }

}
