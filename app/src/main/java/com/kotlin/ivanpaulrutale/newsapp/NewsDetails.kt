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
        val publish_date = intent.getStringExtra("publish_date")
        val source = intent.getStringExtra("source")
        val author = intent.getStringExtra("author")
        val source_url = intent.getStringExtra("source_url")
        val description = intent.getStringExtra("description")
        findViewById<TextView>(R.id.headlineTextView).text = news_headline
        findViewById<TextView>(R.id.publishDateTextView).text = publish_date
        findViewById<TextView>(R.id.sourceTextView).text = source
        findViewById<TextView>(R.id.authorTextView).text = author
        findViewById<TextView>(R.id.descriptionTextView).text = description
        findViewById<TextView>(R.id.sourceUrlTextView).text = source_url

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
