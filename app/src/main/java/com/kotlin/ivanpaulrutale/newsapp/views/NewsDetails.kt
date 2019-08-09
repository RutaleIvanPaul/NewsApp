package com.kotlin.ivanpaulrutale.newsapp.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.kotlin.ivanpaulrutale.newsapp.R
import com.kotlin.ivanpaulrutale.newsapp.database.deleteArticle
import com.kotlin.ivanpaulrutale.newsapp.database.saveArticle
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        val news_headline = intent.getStringExtra("news_headline")
        val news_description = intent.getStringExtra("news_description")
        val publish_date = intent.getStringExtra("publish_date")
        val source = intent.getStringExtra("source")
        val author = intent.getStringExtra("author")
        val url = intent.getStringExtra("url")
        val urlToImage = intent.getStringExtra("urlToImage")
        val from_db = intent.getBooleanExtra("from_db",false)
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
            saveArticle(this,"Shared_Article",source,author,news_headline,news_description,url,urlToImage,publish_date)
            startActivity(sendIntent)
        }

        if (from_db){
            val id = intent.getLongExtra("id",0)
            val delete_button = findViewById<Button>(R.id.SaveButton)
            delete_button.text = "Delete"
            delete_button.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Delete Alert")
                dialogBuilder.setMessage("You are about to delete this article, are you sure?")
                if (activeFragment == "SharedFragment"){
                    dialogBuilder.setPositiveButton("Yes"){dialog,which ->
                        deleteArticle(this,"Shared_Article",id)
                        delete_button.isEnabled = false
                        startActivity(intent)
                    }

                    dialogBuilder.setNegativeButton("No"){dialog, which ->

                    }
                    dialogBuilder.show()
                }
                else{
                    dialogBuilder.setPositiveButton("Yes"){dialog,which ->
                        deleteArticle(this,"Article",id)
                        delete_button.isEnabled = false
                        startActivity(intent)
                    }

                    dialogBuilder.setNegativeButton("No"){dialog, which ->

                    }
                    dialogBuilder.show()
                }
            }
        }
        else{
            val save_button = findViewById<Button>(R.id.SaveButton)
            save_button.setOnClickListener {
                saveArticle(this,"Article",source,author,news_headline,news_description,url,urlToImage,publish_date)
                save_button.isEnabled = false
            }
        }

    }

}
