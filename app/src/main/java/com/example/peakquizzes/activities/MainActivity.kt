package com.example.peakquizzes.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.peakquizzes.R
import com.example.peakquizzes.databinding.ActivityMainBinding
import com.example.peakquizzes.databinding.FragmentMainTeacherButtonsBinding
import com.example.peakquizzes.fragments.TeacherButtonsFragmentDirections
import com.example.peakquizzes.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User


class MainActivity : AppCompatActivity() {
    // These are to be used to test to switch from parent, student and teacher type users which exploring the navigation component
    val TeacherUser = UserModel.User("John", "johnnyboy", "john@gmail.com", "teacher")
    val ParentUser = UserModel.User("Kelly", "Smith", "kelly@gmail.com", "parent")
    val StudentUser = UserModel.User("Jim", "jimmy09", "jimm@gmail.com", "student")
    val testUser = TeacherUser

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        }
    }
//    @ToDo: add functionality that displays the different nav xmls files depending on if the user is a 'teacher', 'parent', or 'student' which starts a different navigation pat
//      Below I tried to dynamically sett the app:defaultNavHost to true, and also inflate the layouts but  as this is an activity and not a fragment, it doesn't work
//        Instead, I would need to adapt the activity_main above

//        binding.parentNavHostFragment
//        binding.studentNavHostFragment
//        binding.teacherNavHostFragment

//        val teacherNavController = Navigation.findNavController(this, R.id.teacherNavHostFragment)
//        val studentNavController = Navigation.findNavController(this, R.id.studentNavHostFragment)
//        val parentNavController = Navigation.findNavController(this, R.id.parentNavHostFragment)
//        if (testUser.type == "teacher") {
//            val finalHost = teacherNavController.navInflater.inflate(R.navigation.parentnavigation);
//        } else if (testUser.type == "parent") {
//            val finalHost = parentNavController.navInflater.inflate(R.navigation.studentnavigation);
//        } else if (testUser.type == "student") {
//            val finalHost = studentNavController.navInflater.inflate(R.navigation.teachernavigation)
//        }
//    }