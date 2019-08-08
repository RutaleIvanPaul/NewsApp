package com.kotlin.ivanpaulrutale.newsapp

import android.support.v4.app.Fragment
import com.kotlin.ivanpaulrutale.newsapp.views.FragmentTemplate
import com.kotlin.ivanpaulrutale.newsapp.views.SavedFragment
import com.kotlin.ivanpaulrutale.newsapp.views.SharedFragment
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Test

import org.junit.Assert.*

class FragmentInstanceTest {
    @Test
    fun test_fragmentTemplate_is_instance_of_Fragment() {
        val fragmentTemplate = FragmentTemplate()
        assertThat(fragmentTemplate,instanceOf(Fragment::class.java))
    }

    @Test
    fun test_savedFragment_is_instance_of_Fragment() {
        val fragmentTemplate = SavedFragment()
        assertThat(fragmentTemplate,instanceOf(Fragment::class.java))
    }

    @Test
    fun test_sharedFragment_is_instance_of_Fragment() {
        val fragmentTemplate = SharedFragment()
        assertThat(fragmentTemplate,instanceOf(Fragment::class.java))
    }
}
