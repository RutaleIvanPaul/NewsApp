package com.kotlin.ivanpaulrutale.newsapp

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.kotlin.ivanpaulrutale.newsapp.adapters.Adapter_DB
import com.kotlin.ivanpaulrutale.newsapp.database.database
import com.kotlin.ivanpaulrutale.newsapp.models.Article
import com.kotlin.ivanpaulrutale.newsapp.models.Article_DB
import com.kotlin.ivanpaulrutale.newsapp.models.NewsReport
import com.kotlin.ivanpaulrutale.newsapp.models.Source
import com.kotlin.ivanpaulrutale.newsapp.views.FragmentTemplate
import com.kotlin.ivanpaulrutale.newsapp.views.MainActivity
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers
import org.jetbrains.anko.db.insert
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test

class SavedNewsTest {

    @Rule
    @JvmField
    var mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    val source = Source("1", "bbc")
    val source2 = Source("1", "bbc")
    val article_DB = Article(
        source,
        "bbc",
        "James",
        "Title",
        "Description",
        "url",
        "https://html.com/wp-content/uploads/flamingo.jpg"
    )

    val news_report = NewsReport("ok",1, arrayListOf(article_DB))
    val news_report1 = NewsReport("ok",1, arrayListOf(article_DB))

    @Test
    fun savedNewsItemClicked(){
        mainActivity.activity.database.use{
            insert("Article",
                "source_name" to news_report.articles[0].source.name,
                "author" to news_report.articles[0].author,
                "title" to news_report.articles[0].title,
                "description" to news_report.articles[0].description,
                "url"  to news_report.articles[0].url,
                "urlToImage" to news_report.articles[0].urlToImage,
                "publishedAt" to news_report.articles[0].publishedAt)
        }
        Thread.sleep(2000)
        onView(withId(R.id.saved)).perform(click())
        val recycler_view: RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
        val itemCount:Int?
        itemCount = recycler_view.adapter?.itemCount
        Thread.sleep(2000)
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<Adapter_DB.ViewHolder>(itemCount!!.minus(1), click()))
        onView(withId(R.id.tableLayout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.SaveButton)).perform(click())
        onView(ViewMatchers.withText("Yes")).perform(click())

        onView(withId(R.id.saved)).perform(click())

        val recycler_view2: RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
        assertEquals(itemCount?.minus(1), recycler_view2.adapter?.itemCount)


    }

    @Test
    fun generalClassCoverageTest(){
        Assert.assertEquals(source == source2, true)
        Assert.assertEquals(news_report == news_report1, true)
        Assert.assertEquals(source.copy("2", "cnn").name, "cnn")
        Assert.assertEquals(source.id, "1")
        assertThat(source.toString(), CoreMatchers.instanceOf(String::class.java))
        assertThat(source.hashCode(), CoreMatchers.instanceOf(Int::class.java))
        Assert.assertEquals(source.name, "bbc")

        assertEquals(news_report.totalResults,1)
        assertEquals(article_DB.source.id,"1")
        assertEquals(article_DB.source.name,"bbc")
        assertEquals(news_report.status,"ok")
        assertEquals(news_report.totalResults,1)
        assertThat(news_report.hashCode(), CoreMatchers.instanceOf(Int::class.java))
        assertThat(news_report.toString(), CoreMatchers.instanceOf(String::class.java))
        assertEquals(news_report.copy("cancel", 1L, listOf(article_DB)).status, "cancel")

        val fragmentTemplate = FragmentTemplate()
        fragmentTemplate.country = "Uganda"
        assertEquals(fragmentTemplate.country,"Uganda")



    }
}