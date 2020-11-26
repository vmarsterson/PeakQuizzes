package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentCreateQuizQuestionFormBinding
import com.example.peakquizzes.databinding.FragmentCreateQuizTitleBinding

class CreateQuizTitleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateQuizTitleBinding>(inflater, R.layout.fragment_create_quiz_title, container, false)
        binding.createQuizTitleButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_createQuizTitleFragment_to_createQuizFormFragment))
        return binding.root
    }
}