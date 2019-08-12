package com.kotlin.ivanpaulrutale.newsapp.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.kotlin.ivanpaulrutale.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.home -> {
                spinner.visibility = View.VISIBLE
                replaceFragment(FragmentTemplate.newInstance("Uganda"))
                populateSpinner()
                return@OnNavigationItemSelectedListener true
            }
            R.id.saved -> {
                spinner.visibility = View.GONE
                replaceFragment(SavedFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.shared -> {
                spinner.visibility = View.GONE
                replaceFragment(SharedFragment())
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                return@OnNavigationItemSelectedListener false
            }
        }
    }


    private fun populateSpinner() {

        val cityNames = arrayOf("Kampala","Lagos", "Nairobi", "NewYork", "Kigali")
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cityNames)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    showSelectedItems(cityNames[position])
                }
            }
        }
    }

    private fun showSelectedItems(position: String) {
        var newFragment:FragmentTemplate?=null

        when(position){
            "Lagos"->{
                newFragment = FragmentTemplate.newInstance("Nigeria")
            }
            "Nairobi"->{
                newFragment = FragmentTemplate.newInstance("Kenya")
            }
            "Kampala"->{
                newFragment = FragmentTemplate.newInstance("Uganda")
            }
            "NewYork"->{
                newFragment = FragmentTemplate.newInstance("NewYork")
            }
            "Kigali"->{
                newFragment = FragmentTemplate.newInstance("Rwanda")
            }
        }
        replaceFragment(newFragment!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateSpinner()
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}
