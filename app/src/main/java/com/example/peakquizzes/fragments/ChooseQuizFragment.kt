package com.example.peakquizzes.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.FragmentDisplayQuizMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class ChooseQuizFragment: Fragment() {
    val TAG = "Choose Quiz Fragment"
    val db = FirebaseFirestore.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        getQuizes()
       val binding = DataBindingUtil.inflate<FragmentDisplayQuizMainBinding>(inflater, R.layout.fragment_display_quiz_main, container, false)
        binding.displayQuiz1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chooseQuizFragment_to_displayQuizFragment))
        binding.createQuizButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_chooseQuizFragment_to_createQuizConfirmFragment))
        return binding.root
    }

    fun getQuizes() {
        val docRef = db.collection("users").document()
            .collection("quiz")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data:")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

}