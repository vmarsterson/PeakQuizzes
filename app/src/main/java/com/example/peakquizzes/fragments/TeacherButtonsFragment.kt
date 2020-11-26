package com.example.peakquizzes.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentMainTeacherButtonsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class TeacherButtonsFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    val name: String = "Terry"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val binding = DataBindingUtil.inflate<FragmentMainTeacherButtonsBinding>(inflater, R.layout.fragment_main_teacher_buttons, container, false)
        binding.createQuizButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_teacherButtonsFragment_to_createQuizConfirmFragment))
        binding.viewQuizzesButton
        binding.testMyKnowledgeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_teacherButtonsFragment_to_chooseQuizFragment))
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
