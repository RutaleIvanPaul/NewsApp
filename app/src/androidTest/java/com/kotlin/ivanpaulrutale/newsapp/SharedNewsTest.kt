package com.kotlin.ivanpaulrutale.newsapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import androidx.test.uiautomator.UiDevice
import com.kotlin.ivanpaulrutale.newsapp.adapters.Adapter_DB
import com.kotlin.ivanpaulrutale.newsapp.adapters.CustomAdapter
import com.kotlin.ivanpaulrutale.newsapp.database.database
import com.kotlin.ivanpaulrutale.newsapp.models.Article_DB
import com.kotlin.ivanpaulrutale.newsapp.views.MainActivity
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.jetbrains.anko.db.insert
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SharedNewsTest {

    @Rule
    @JvmField
    var mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun sharedNewsItemClicked(){
        val article_DB = Article_DB(
            1,
            "BBC",
            "James",
            "Title",
            "Description",
            "url",
            "https://html.com/wp-content/uploads/flamingo.jpg",
            "published"
        )
        mainActivity.activity.database.use{
            insert("Shared_Article",
                "source_name" to article_DB.source,
                "author" to article_DB.author,
                "title" to article_DB.title,
                "description" to article_DB.description,
                "url"  to article_DB.url,
                "urlToImage" to article_DB.urlToImage,
                "publishedAt" to article_DB.publishedAt)
        }
        Thread.sleep(2000)
        onView(withId(R.id.shared)).perform(click())
        val recycler_view: RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
        val itemCount:Int?
        itemCount = recycler_view.adapter?.itemCount
        Thread.sleep(2000)
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<Adapter_DB.ViewHolder>(itemCount!!.minus(1), click()))
        onView(withId(R.id.tableLayout)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.SaveButton)).perform(click())
        onView(withText("Yes")).perform(click())

        onView(withId(R.id.shared)).perform(click())

        val recycler_view2: RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
        Assert.assertEquals(itemCount?.minus(1), recycler_view2.adapter?.itemCount)


    }

//    @Test
//    fun shareNewsItemTest(){
//        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//
//        onView(withId(R.id.shared)).perform(click())
//        val recycler_view: RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
//        val itemCount:Int?
//        itemCount = recycler_view.adapter?.itemCount
//        Thread.sleep(5000)
//
//        onView(withId(R.id.home)).perform(click())
//        Thread.sleep(5000)
//        onView(withId(R.id.recycler_view))
//            .perform(RecyclerViewActions.actionOnItemAtPosition<CustomAdapter.ViewHolder>(2, click()))
//        onView(withId(R.id.ShareButton)).perform(click())
//        device.pressBack()
//        pressBack()
//
//        onView(withId(R.id.shared)).perform(click())
//
//        val recycler_view2: RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
//        assertEquals(itemCount?.plus(1), recycler_view2.adapter?.itemCount)
//
//        Thread.sleep(5000)
//        onView(withId(R.id.recycler_view))
//            .perform(RecyclerViewActions.actionOnItemAtPosition<Adapter_DB.ViewHolder>(itemCount!!.minus(1), click()))
//        onView(withId(R.id.tableLayout)).check(matches(isDisplayed()))
//        onView(withId(R.id.SaveButton)).perform(click())
//        onView(withText("Yes")).perform(click())
//
//    }

}