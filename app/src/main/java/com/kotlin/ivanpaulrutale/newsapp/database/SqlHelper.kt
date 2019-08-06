package com.kotlin.ivanpaulrutale.newsapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class SqlHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "saved_news") {

    companion object {
        private var instance: SqlHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): SqlHelper {
            if (instance == null) {
                instance = SqlHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable("Article",true,
            "_id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "source_name" to TEXT,
            "author" to TEXT,
            "title" to TEXT,
            "description" to TEXT,
            "url" to TEXT,
            "urlToImage" to TEXT,
            "publishedAt" to TEXT)

        db.createTable("Shared_Article",true,
            "_id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "source_name" to TEXT,
            "author" to TEXT,
            "title" to TEXT,
            "description" to TEXT,
            "url" to TEXT,
            "urlToImage" to TEXT,
            "publishedAt" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    }


// Access property for Context
val Context.database: SqlHelper
    get() = SqlHelper.getInstance(applicationContext)