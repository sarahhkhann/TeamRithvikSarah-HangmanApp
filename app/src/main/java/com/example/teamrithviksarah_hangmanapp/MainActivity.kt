package com.example.teamrithviksarah_hangmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var hangmanViewModel: HangmanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set view model
        hangmanViewModel = ViewModelProvider(this).get(HangmanViewModel::class.java)

        hangmanViewModel.getGuessesLeft()






    }
}