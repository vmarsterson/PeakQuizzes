package com.example.peakquizzes.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentCreateQuizConfirmBinding
import com.example.peakquizzes.databinding.FragmentDisplayQuizMainBinding

class CreateQuizConfirmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateQuizConfirmBinding>(
            inflater,
            R.layout.fragment_create_quiz_confirm,
            container,
            false
        )
        binding.createQuizConfirmButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_createQuizConfirmFragment_to_createQuizTitleFragment
            )
        )
        var args = TeacherButtonsFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, args.teacherusername, Toast.LENGTH_LONG).show()
    return binding.root
    }
}