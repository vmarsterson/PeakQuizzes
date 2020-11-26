package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.peakquizzes.R
import com.example.peakquizzes.activities.auth
import com.example.peakquizzes.databinding.FragmentMainStudentButtonsBinding
import com.example.peakquizzes.databinding.FragmentMainTeacherButtonsBinding

class StudentButtonsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainStudentButtonsBinding>(inflater, R.layout.fragment_main_student_buttons, container, false)
        binding.testMyKnowledgeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_studentButtonsFragment_to_chooseQuizFragment2))
        binding.helpButton
        binding.logoutButton.setOnClickListener{
            logOut()
        }
        return binding.root
    }

    fun logOut() {
        auth.signOut()
        view?.findNavController()?.navigate(R.id.action_teacherButtonsFragment_to_loginActivity)
    }
}