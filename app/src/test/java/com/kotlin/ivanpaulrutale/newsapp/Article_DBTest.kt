package com.kotlin.ivanpaulrutale.newsapp

import com.kotlin.ivanpaulrutale.newsapp.models.Article_DB
import org.junit.Assert
import org.junit.Test

class Article_DBTest() {
    @Test
    fun test_newsReports_DB() {
        val article =
            Article_DB(
                1,
                "BBC",
                "jane doe",
                "title",
                "description",
                "url",
                "urltoImage",
                "2019-01-01"
            )
        Assert.assertEquals(article.source, "BBC")
        Assert.assertEquals(article.author, "jane doe")
        Assert.assertEquals(article.title, "title")
        Assert.assertEquals(article.description, "description")
        Assert.assertEquals(article.url, "url")
        Assert.assertEquals(article.urlToImage, "urltoImage")
        Assert.assertEquals(article.publishedAt, "2019-01-01")

    }
}