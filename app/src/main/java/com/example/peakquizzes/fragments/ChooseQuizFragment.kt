package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentDisplayQuizMainBinding

class ChooseQuizFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
       val binding = DataBindingUtil.inflate<FragmentDisplayQuizMainBinding>(inflater, R.layout.fragment_display_quiz_main, container, false)
        binding.displayQuiz1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chooseQuizFragment_to_displayQuizFragment))
        binding.createQuizButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chooseQuizFragment_to_createQuizConfirmFragment))
        return binding.root
    }
}