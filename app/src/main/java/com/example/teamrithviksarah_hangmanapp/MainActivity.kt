package com.example.teamrithviksarah_hangmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager


        // Example: Replace a fragment
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.selectWords, lettersfragment())
        transaction.commit()




    }
}