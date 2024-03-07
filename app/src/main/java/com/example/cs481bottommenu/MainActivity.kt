package com.example.cs481bottommenu

import Fragments.chartfrag
import Fragments.homefrag
import Fragments.settingsfrag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = homefrag()
        val chartFragment = chartfrag()
        val settingFragment = settingsfrag()

        changeFragment(homeFragment)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_home -> {
                    changeFragment(homeFragment)
                    true
                }

                R.id.ic_chart -> {
                    changeFragment(chartFragment)
                    true
                }

                R.id.ic_settings -> {
                    changeFragment(settingFragment)
                    true
                }

                else -> false

            }
        }
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fcontainer,fragment)
            commit()
        }
    }




    }
