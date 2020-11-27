package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.peakquizzes.R
import com.example.peakquizzes.activities.auth
import com.example.peakquizzes.databinding.FragmentCreateQuizTitleBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class CreateQuizTitleFragment : Fragment() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateQuizTitleBinding>(inflater, R.layout.fragment_create_quiz_title, container, false)


        binding.createQuizTitleButton.setOnClickListener{
            binding.quiztitle = this
            val userQuizTitle = binding.createQuizTitle.text.toString()
            val quizStructure: MutableMap<String, Any> = hashMapOf(
                "title" to userQuizTitle,
                "question" to "",
                "correctAnswer" to "",
                "incorrectAnswerA" to "",
                "incorrectAnswerB" to ""
            )

            db
                .collection("users").document("Mary")
                .collection("quiz").document(userQuizTitle)
                .set(quizStructure, SetOptions.merge())
                .addOnSuccessListener {
                    Toast.makeText(activity,"Saved Title", Toast.LENGTH_SHORT).show()
//                    view?.findNavController()?.navigate(R.id.action_createQuizTitleFragment_to_createQuizFormFragment)
                    view?.findNavController()?.navigate(CreateQuizTitleFragmentDirections.actionCreateQuizTitleFragmentToCreateQuizFormFragment(1))
                }
                .addOnFailureListener {
                    Toast.makeText(activity,"Failed to Save Title", Toast.LENGTH_SHORT).show()}
        }
            return binding.root
        }
}