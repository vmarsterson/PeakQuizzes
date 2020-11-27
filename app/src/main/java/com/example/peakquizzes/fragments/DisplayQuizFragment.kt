package com.example.peakquizzes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentDisplayQuizQuestionBinding

class DisplayQuizFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>
    )
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What colour is my hair?",
            answers = listOf("Pink", "Blue", "Green")
        ),
        Question(
            text = "How far can I run in 25 mins?",
            answers = listOf("2k", "25k", "5k")
        ),
        Question(
            text = "Why does it always rain on me?",
            answers = listOf(
                "I lied when I was 17",
                "Precipitation favours the bold",
                "You\'re paranoid"
            )
        )
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>


    fun setQuestion() {
        currentQuestion = questions[0]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDisplayQuizQuestionBinding>(
            inflater, R.layout.fragment_display_quiz_question, container, false
        )

        setQuestion()
        binding.quiz = this

        binding.quizAnswerA.setOnClickListener {
            val texta = binding.quizAnswerA.text
            if ( texta == currentQuestion.answers[0]) {
                displayCongratulationsToast() }
            else {
                displayCommiserationsToast()
                }
        }

        binding.quizAnswerB.setOnClickListener{
            val textb = binding.quizAnswerB.text
            if (textb == currentQuestion.answers[0]) {
                displayCongratulationsToast()}
            else {
                displayCommiserationsToast()
            }
        }

        binding.quizAnswerC.setOnClickListener{
            val textc = binding.quizAnswerC.text
            if (textc == currentQuestion.answers[0]) { displayCongratulationsToast() }
            else {
                displayCommiserationsToast()
            }
        }

        return binding.root
    }

    private fun displayCongratulationsToast() {
        Toast.makeText(activity,"That's right!", Toast.LENGTH_SHORT).show()

    }
    private fun displayCommiserationsToast() {
        Toast.makeText(activity,"Hmm... That's not quite right!", Toast.LENGTH_SHORT).show()
    }

    }