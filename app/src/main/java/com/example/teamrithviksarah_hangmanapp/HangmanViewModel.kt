package com.example.teamrithviksarah_hangmanapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HangmanViewModel : ViewModel() {

    //variable to hold the word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String> = _word

    //variable to hold number of guesses
    private val _guessesLeft = MutableLiveData<Int>()
    val guessesLeft: LiveData<Int> = _guessesLeft

    init {
        resetGame()
    }
    private fun resetGame() {
        _word.value = "plank"
        _guessesLeft.value = 8

    }

    fun getGuessesLeft(): Int? {
        return _guessesLeft.value
    }


}