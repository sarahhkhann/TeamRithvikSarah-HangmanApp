package com.example.teamrithviksarah_hangmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {

    lateinit var hangmanViewModel: HangmanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hangmanViewModel = ViewModelProvider(this).get(HangmanViewModel::class.java)

        hangmanViewModel.getGuessesLeft()
        
        // Get the FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager


        // Example: Replace a fragment
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.selectWords, lettersFragment())
        transaction.replace(R.id.hangmanGame, HangmanMainDisplay())
        transaction.commit()


    }
}