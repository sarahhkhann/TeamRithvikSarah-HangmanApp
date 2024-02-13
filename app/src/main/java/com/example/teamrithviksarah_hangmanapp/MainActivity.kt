package com.example.teamrithviksarah_hangmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import android.content.res.Configuration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction1 = supportFragmentManager.beginTransaction()
        val fragment = hintfragment()
        val hangmanfragment = HangmanMainDisplay()

        // Example: Replace a fragment
        val transaction = fragmentManager.beginTransaction()
        //transaction.replace(R.id.selectWords, lettersfragment())

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            transaction.replace(R.id.hangmanGame, hangmanfragment)
            transaction.replace(R.id.selectWords, lettersFragment())
            transaction.commit()
        }


        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.hintpanel, fragment)
            transaction.replace(R.id.hangmanGame, hangmanfragment)
            transaction.replace(R.id.selectWords, lettersFragment())
            transaction.commit()
        }

    }


}