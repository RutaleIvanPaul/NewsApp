package com.kotlin.ivanpaulrutale.newsapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_news_details.*

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
        findViewById<TextView>(R.id.headlineTextView).text = news_headline
        findViewById<TextView>(R.id.descriptionTextView).text = news_description
        findViewById<TextView>(R.id.publishDateTextView).text = publish_date
        findViewById<TextView>(R.id.sourceTextView).text = source
        findViewById<TextView>(R.id.authorTextView).text = author
        findViewById<TextView>(R.id.sourceUrlTextView).text = url


    }

}
