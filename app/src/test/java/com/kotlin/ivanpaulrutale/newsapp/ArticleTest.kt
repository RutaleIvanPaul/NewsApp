package com.kotlin.ivanpaulrutale.newsapp

import com.kotlin.ivanpaulrutale.newsapp.models.Article
import com.kotlin.ivanpaulrutale.newsapp.models.NewsReport
import com.kotlin.ivanpaulrutale.newsapp.models.Source
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

class ArticleTest {
    @Test
    fun test_newsReports() {
        val source = Source("1", "bbc")
        val source2 = Source("1", "bbc")
        Assert.assertEquals(source == source2, true)
        Assert.assertEquals(source.copy("2", "cnn").name, "cnn")
        Assert.assertEquals(source.id, "1")
        Assert.assertThat(source.toString(), CoreMatchers.instanceOf(String::class.java))
        Assert.assertThat(source.hashCode(), CoreMatchers.instanceOf(Int::class.java))
        Assert.assertEquals(source.name, "bbc")
        val article =
            Article(
                source,
                "jane doe",
                "title",
                "description",
                "url",
                "urltoImage",
                "2019-01-01"
            )
        Assert.assertEquals(article.source, source)
        Assert.assertEquals(article.author, "jane doe")
        Assert.assertEquals(article.title, "title")
        Assert.assertEquals(article.description, "description")
        Assert.assertEquals(article.url, "url")
        Assert.assertEquals(article.urlToImage, "urltoImage")
        Assert.assertEquals(article.publishedAt, "2019-01-01")

        val newsReport = NewsReport("ok", 1L, listOf(article))
        val newsReport2 = NewsReport("ok", 1L, listOf(article))
        Assert.assertEquals(newsReport == newsReport2, true)
        Assert.assertEquals(newsReport.status, "ok")
        Assert.assertEquals(newsReport.totalResults, 1L)
        Assert.assertEquals(newsReport.articles[0], article)
        Assert.assertEquals(newsReport.copy("cancel", 1L, listOf(article)).status, "cancel")
        Assert.assertThat(newsReport.hashCode(), CoreMatchers.instanceOf(Int::class.java))
        Assert.assertThat(newsReport.toString(), CoreMatchers.instanceOf(String::class.java))
    }
}