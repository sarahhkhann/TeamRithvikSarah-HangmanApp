package com.example.teamrithviksarah_hangmanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class lettersFragment : Fragment() {

    companion object {
        fun newInstance() = lettersFragment()
    }

    private lateinit var viewModel: HangmanViewModel

    // Update this list to include all your button IDs
    val buttonIds = listOf(
        R.id.q, R.id.w, R.id.e, R.id.r, R.id.t, R.id.y, R.id.u, R.id.i, R.id.o, R.id.p,
        R.id.a, R.id.s, R.id.d, R.id.f, R.id.g, R.id.h, R.id.j, R.id.k, R.id.l,
        R.id.z, R.id.x, R.id.c, R.id.v, R.id.b, R.id.n, R.id.m
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(requireActivity()).get(HangmanViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_lettersfragment, container, false)


        // Set the same click listener for all letter buttons
        buttonIds.forEach { buttonId ->
            view.findViewById<Button>(buttonId)?.setOnClickListener { buttonView ->
                // Directly handle the click event here
                if (buttonView is Button) {
                    val letter = buttonView.text.toString()

                    //send data to View Model
                    viewModel.setCurrentLetter(letter)


                }
            }
        }

        return view
    }

    // Function to reset button colors
    public fun resetButtonColors() {
        buttonIds.forEach { buttonId ->
            view?.findViewById<Button>(buttonId)?.setBackgroundColor(resources.getColor(android.R.color.transparent, null))
        }
    }
}
