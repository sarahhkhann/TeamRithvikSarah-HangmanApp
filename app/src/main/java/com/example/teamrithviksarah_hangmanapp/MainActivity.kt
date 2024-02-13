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

        //Word bank for the game
        val words = listOf("chair", "alien", "grape", "wheel")


        //A variable to keep track of the number of hints they used
        val hint_num = 0

        //Hints for each of the words
        val wordHints = mapOf(
            "chair" to "An object you sit on.",
            "alien" to "An extraterrestrial visitor.",
            "grape" to "A small, round purple fruit",
            "wheel" to "You would have trouble riding a bicycle without this."
        )


        // Get the FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction1 = supportFragmentManager.beginTransaction()
        val fragment = hintfragment()
        val hangmanfragment = HangmanMainDisplay()
        val letters = lettersFragment()

        // Example: Replace a fragment
        val transaction = fragmentManager.beginTransaction()
        //transaction.replace(R.id.selectWords, lettersfragment())

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            transaction.replace(R.id.hangmanGame, hangmanfragment)
            transaction.replace(R.id.selectWords, letters)
        }


        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.hintpanel, fragment)
            transaction.replace(R.id.hangmanGame, hangmanfragment)
            transaction.replace(R.id.selectWords, letters)
            transaction.commit()
        }

    }


}