package com.kotlin.ivanpaulrutale.newsapp.models

/**
 * 3 classes responsible for how our requests are represented.
 */
data class NewsReport(
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)

class Article(
    val source: Source,
    val author: String? = null,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)

class Article_DB(
    val id: Long,
    val source: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)

data class Source(
    val id: String? = null,
    val name: String
)
