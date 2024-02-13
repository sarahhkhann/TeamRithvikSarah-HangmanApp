package com.example.teamrithviksarah_hangmanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.teamrithviksarah_hangmanapp.HangmanViewModel
import com.example.teamrithviksarah_hangmanapp.R
import com.google.android.material.snackbar.Snackbar

class HangmanMainDisplay : Fragment() {

    private lateinit var viewModel: HangmanViewModel
    private lateinit var image: ImageView
    private val textViews = mutableListOf<TextView>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(requireActivity())[HangmanViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_hangman_main_display, container, false)


        image = view.findViewById(R.id.hangmanImageView)

        // Initialize TextViews based on IDs
        val textViewIds = listOf(R.id.letter1, R.id.letter2, R.id.letter3, R.id.letter4, R.id.letter5)
        textViewIds.forEach { id ->
            val textView = view.findViewById<TextView>(id)
            textViews.add(textView)
        }

        // Observe changes in revealed letters to update UI
        viewModel.revealedLetters.observe(viewLifecycleOwner, Observer { revealed ->
            updateTextViewsWithRevealedLetters(revealed)
        })

        // Observe changes in the guesses left to update the hangman image
        viewModel.guessesLeft.observe(viewLifecycleOwner, Observer { guessesLeft ->
            updateHangmanImage(guessesLeft)
        })

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the revealed letters to the bundle
        outState.putString("revealedLetters", viewModel.revealedLetters.value)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Restore the revealed letters from the bundle, if available
        savedInstanceState?.getString("revealedLetters")?.let { revealedLetters ->
            updateTextViewsWithRevealedLetters(revealedLetters)
        }
    }

    private fun updateTextViewsWithRevealedLetters(revealed: String) {
        textViews.forEachIndexed { index, textView ->
            if (index < revealed.length) {
                textView.text = revealed[index].toString()
            }
        }
    }

    private fun updateHangmanImage(guessesLeft: Int) {
        when (guessesLeft) {
            6 -> image.setImageResource(R.drawable.head)
            5 -> image.setImageResource(R.drawable.body)
            4 -> image.setImageResource(R.drawable.oneleg)
            3 -> image.setImageResource(R.drawable.twoleg)
            2 -> image.setImageResource(R.drawable.legsonearm)
            1 -> image.setImageResource(R.drawable.twoarms)
            0 -> {
                image.setImageResource(R.drawable.dead)
                showResetGameSnackbar()
            }
            else -> image.setImageResource(R.drawable.blank_hangman) // Default or initial state
        }
    }

    private fun showResetGameSnackbar() {
        view?.let { view ->
            Snackbar.make(view, "You've run out of lives! Want to play again?", Snackbar.LENGTH_INDEFINITE)
                .setAction("Reset") {
                    viewModel.resetGame()
                    resetTextViewsAndImage()
                }.show()
        }
    }

    private fun resetTextViewsAndImage() {
        textViews.forEach { it.text = "" }
        image.setImageResource(R.drawable.blank_hangman)
        lettersFragment
    }
}
