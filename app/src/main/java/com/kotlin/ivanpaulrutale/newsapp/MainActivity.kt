package com.kotlin.ivanpaulrutale.newsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.kotlin.ivanpaulrutale.newsapp.Views.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.home -> {
                replaceFragment(FragmentTemplate.newInstance("ug"))
                populateSpinner()
                return@OnNavigationItemSelectedListener true
            }
            R.id.saved -> {
                replaceFragment(SavedFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.shared -> {
                replaceFragment(SharedFragment())
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                return@OnNavigationItemSelectedListener false
            }
        }
    }


    private fun populateSpinner() {

        val cityNames = arrayOf("Kampala","Lagos", "Nairobi", "Newyork", "Kigali")
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cityNames)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    showSelectedItems(cityNames[position])
                    Toast.makeText(this@MainActivity, cityNames[position], Toast.LENGTH_SHORT).show()
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
            "Newyork"->{
                newFragment = FragmentTemplate.newInstance("Newyork")
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
//        replaceFragment(NewyorkFragment())
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}
