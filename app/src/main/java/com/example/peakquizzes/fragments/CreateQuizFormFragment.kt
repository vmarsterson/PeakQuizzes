package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.peakquizzes.R
import com.example.peakquizzes.activities.auth
import com.example.peakquizzes.databinding.FragmentCreateQuizConfirmBinding
import com.example.peakquizzes.databinding.FragmentCreateQuizQuestionFormBinding
import com.example.peakquizzes.models.QuizModel
import com.example.peakquizzes.models.UserModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class CreateQuizFormFragment : Fragment() {

    val db = FirebaseFirestore.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateQuizQuestionFormBinding>(
            inflater,
            R.layout.fragment_create_quiz_question_form,
            container,
            false
        )
//        var args = CreateQuizTitleFragmentArgs.fromBundle(requireArguments())
//        Toast.makeText(context, args.quizTitle, Toast.LENGTH_LONG).show()
        binding.questionform = this
        binding.createQuizFormAddQuestionButton.setOnClickListener {

            val userQuestion = binding.createQuizQuestion.text.toString()
            val correctAnswer = binding.createQuizA1.text.toString()
            val wrongAnswerA = binding.createQuizA2.text.toString()
            val wrongAnswerB = binding.createQuizA3.text.toString()
            val questionCollection = mutableListOf(correctAnswer, wrongAnswerA, wrongAnswerB)
            val question: MutableMap<String, Any> = hashMapOf(
                "question" to userQuestion,
                "correctAnswer" to correctAnswer,
                "incorrectAnswerA" to wrongAnswerA,
                "incorrectAnswerB" to wrongAnswerB
            )

            db
                .collection("users").document("Verity")
                .collection("quiz").document("Colours")
                .set(question, SetOptions.merge())
                .addOnSuccessListener {
                    Toast.makeText(activity, "Quiz Successfully Saved", Toast.LENGTH_SHORT).show()
                    view?.findNavController()
                        ?.navigate(R.id.action_createQuizFormFragment_self)
                }
                .addOnFailureListener {
                    Toast.makeText(activity, "Error, please try again", Toast.LENGTH_SHORT).show()
                    view?.findNavController()?.navigate(R.id.action_createQuizFormFragment_self)
                }
        }
            binding.createQuizFormSubmitButton.setOnClickListener {
                view?.findNavController()?.navigate(
                    R.id.action_createQuizFormFragment_to_teacherButtonsFragment
                )
        }
            return binding.root
        }

}
