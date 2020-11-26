package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentCreateQuizConfirmBinding
import com.example.peakquizzes.databinding.FragmentCreateQuizQuestionFormBinding

class CreateQuizFormFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateQuizQuestionFormBinding>(inflater, R.layout.fragment_create_quiz_question_form, container, false)
        binding.createQuizFormAddQuestionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_createQuizFormFragment_self))
        binding.createQuizFormSubmitButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_createQuizFormFragment_to_teacherButtonsFragment))
        return binding.root
    }
}