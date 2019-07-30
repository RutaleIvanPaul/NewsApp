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
        findViewById<TextView>(R.id.headlineTextView).text = news_headline

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
