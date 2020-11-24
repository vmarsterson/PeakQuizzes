package com.example.peakquizzes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
//        val model: RegisterViewModel by viewModels()
//        auth = FirebaseAuth.getInstance()
//
//        button_register.setOnClickListener {
//            model.saveUserData()
//        }
//
//        button_login_redirect.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }
    }
}