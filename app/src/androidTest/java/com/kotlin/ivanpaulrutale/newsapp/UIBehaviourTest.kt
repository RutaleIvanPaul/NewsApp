package com.kotlin.ivanpaulrutale.newsapp

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.kotlin.ivanpaulrutale.newsapp.views.MainActivity
import org.hamcrest.Matchers.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.v7.widget.RecyclerView
import com.kotlin.ivanpaulrutale.newsapp.adapters.CustomAdapter


@RunWith(AndroidJUnit4::class)
class UIBehaviourTest {

    @Rule
    @JvmField
    var mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun bottomNavigationClickedTest(){
        onView(withId(R.id.home)).check(matches(isDisplayed()))
        onView(withId(R.id.spinner)).check(matches(isDisplayed()))

        onView(withId(R.id.saved)).perform(click())
        onView(withId(R.id.spinner)).check(matches(not(isDisplayed())))

        onView(withId(R.id.shared)).perform(click())
        onView(withId(R.id.spinner)).check(matches(not(isDisplayed())))
    }

    @Test
    fun spinnerClickedTest(){
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(instanceOf(String::class.java))).atPosition(0).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(instanceOf(String::class.java))).atPosition(1).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(instanceOf(String::class.java))).atPosition(2).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(instanceOf(String::class.java))).atPosition(3).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(instanceOf(String::class.java))).atPosition(4).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun newsListItemClicked(){
        Thread.sleep(5000)
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CustomAdapter.ViewHolder>(3, click()))
        onView(withId(R.id.tableLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun saveNewsListItemClicked(){
        onView(withId(R.id.saved)).perform(click())

        val recycler_view:RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
        val itemCount:Int?
        itemCount = recycler_view.adapter?.itemCount

        onView(withId(R.id.home)).perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CustomAdapter.ViewHolder>(3, click()))
        onView(withId(R.id.SaveButton)).perform(click())
        pressBack()


        onView(withId(R.id.saved)).perform(click())
        val recycler_view2:RecyclerView = mainActivity.getActivity().findViewById(R.id.recycler_view)
        assertEquals(itemCount?.plus(1),recycler_view2.adapter?.itemCount)
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CustomAdapter.ViewHolder>(recycler_view.adapter?.itemCount!!, click()))
        onView(withId(R.id.tableLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.SaveButton)).perform(click())
    }


}
