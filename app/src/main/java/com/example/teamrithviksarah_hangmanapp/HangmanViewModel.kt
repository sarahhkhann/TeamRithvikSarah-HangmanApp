package com.example.teamrithviksarah_hangmanapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HangmanViewModel : ViewModel() {

    private val _word = MutableLiveData<String>()
    val word: LiveData<String> = _word

    private val _guessesLeft = MutableLiveData<Int>()
    val guessesLeft: LiveData<Int> = _guessesLeft

    private val _currentLetter = MutableLiveData<String>()
    val currentLetter: LiveData<String> = _currentLetter

    // Add a LiveData to track the revealed letters
    private val _revealedLetters = MutableLiveData<String>()
    val revealedLetters: LiveData<String> = _revealedLetters

    private val hangmanWords = mapOf(
        "chair" to "An object you sit on.",
        "alien" to "An extraterrestrial visitor.",
        "grape" to "A small, round purple fruit",
        "wheel" to "You would have trouble riding a bicycle without this."
    )

    init {
        resetGame()
    }

    fun resetGame() {
        val randomWord = hangmanWords.keys.random()
        _word.value = randomWord
        _guessesLeft.value = 7
        // Initialize revealedLetters with underscores representing each letter of the new word
        _revealedLetters.value = "_".repeat(randomWord.length)
    }

    fun getGuessesLeft(): Int? = _guessesLeft.value

    fun setCurrentLetter(letter: String) {
        Log.d("SetLetter", letter)
        _currentLetter.value = letter
        revealLetter(letter)
    }

    fun getCurrentLetter(): String? = currentLetter.value

    fun lowerGuesses() {
        _guessesLeft.value = (_guessesLeft.value ?: 0) - 1
    }

    fun getGuessLeft(): Int? = _guessesLeft.value

    fun getHintForCurrentWord(): String? = _word.value?.let { hangmanWords[it] }

    private fun revealLetter(letter: String) {
        val currentWord = _word.value ?: return
        val revealed = _revealedLetters.value?.toCharArray() ?: return

        var letterFound = false // Flag to track if the letter was found

        currentWord.forEachIndexed { index, c ->
            if (c.toString().equals(letter, ignoreCase = true)) {
                revealed[index] = c
                letterFound = true // Set flag to true if letter is found
            }
        }

        // Update the revealed letters only if the letter was found
        if (letterFound) {
            _revealedLetters.value = String(revealed)
        } else {
            // If the letter wasn't found, decrement the guesses left
            lowerGuesses()
        }
    }

}
