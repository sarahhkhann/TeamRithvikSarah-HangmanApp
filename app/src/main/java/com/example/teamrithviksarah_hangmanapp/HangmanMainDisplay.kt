package com.example.teamrithviksarah_hangmanapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class HangmanMainDisplay : Fragment() {


    companion object {
        fun newInstance() = HangmanMainDisplay()
    }

    private lateinit var viewModel: HangmanViewModel
    // Update this list to include all the text views
    val textViewIds = listOf(
        R.id.letter1, R.id.letter2, R.id.letter3, R.id.letter4, R.id.letter5)

    private val textViews = mutableListOf<TextView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(requireActivity()).get(HangmanViewModel::class.java)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hangman_main_display, container, false)

        // Initialize TextViews
        textViewIds.forEach { id ->
            val textView = view.findViewById<TextView>(id)
            textViews.add(textView)
        }

        Log.d("Hangman", "JELLO")

        viewModel.currentLetter.observe(viewLifecycleOwner, Observer { letter ->

            textViews[0].text = letter
        })



        return view
    }

}