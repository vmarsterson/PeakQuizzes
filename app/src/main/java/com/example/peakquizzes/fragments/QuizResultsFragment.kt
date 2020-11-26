package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentDisplayQuizQuestionResultBinding

class QuizResultsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDisplayQuizQuestionResultBinding>(inflater, R.layout.fragment_display_quiz_quiz_result, container, false)
        binding.nextQuestionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_quizResultsFragment_to_teacherButtonsFragment))
        return binding.root
    }
}