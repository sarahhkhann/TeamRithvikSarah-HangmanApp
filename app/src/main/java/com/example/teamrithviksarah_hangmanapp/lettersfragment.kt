package com.example.teamrithviksarah_hangmanapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class lettersfragment : Fragment() {

    companion object {
        fun newInstance() = lettersfragment()
    }

    private lateinit var viewModel: LettersfragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lettersfragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LettersfragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}