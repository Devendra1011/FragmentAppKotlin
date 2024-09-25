package com.example.fragmentapp

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnDisplayFragment1:Button = findViewById(R.id.btn_displayFragment1)
        val btnDisplayFragment2:Button = findViewById(R.id.btn_displayFragment2)
        val frameLayout:FrameLayout = findViewById(R.id.frame_layout)

        btnDisplayFragment1.setOnClickListener{
            val fragment1: FragmentOne = FragmentOne()
            loadFragment(fragment1)
        }

        btnDisplayFragment2.setOnClickListener{
            val fragment2 = FragmentTwo()
            loadFragment(fragment2)
        }


    }
    fun loadFragment(fragment: Fragment){


        // Fragment Manager : responsible for managing fragments
        // in activity .It keeps track of the fragment lifecycle
        // and handles transactions involving fragments

        val fragmentManager = supportFragmentManager
        // Fragment Transaction : used to define a set of operations
        // to be perform on fragments

        val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()

        // Replacing the frameLayout with new fragment
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()




    }
}