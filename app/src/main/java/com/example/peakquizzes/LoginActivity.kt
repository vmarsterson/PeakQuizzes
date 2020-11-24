package com.example.peakquizzes

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

//        auth = FirebaseAuth.getInstance()
//
//        button_register_redirect.setOnClickListener {
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
//        }
//
//        button_login.setOnClickListener {
//            loginUser()
//        }
//    }
//
//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        updateUI(currentUser)
//    }
//
//    private fun updateUI(currentUser: FirebaseUser?) {
//        if (currentUser != null ) {
//            if(currentUser.isEmailVerified) {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }else{
//                Toast.makeText(
//                    baseContext, "Please verify your email address.",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        } else {
////            if current user errors
//            Toast.makeText(
//                baseContext, "Login failed, please try again",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//
//    private fun loginUser() {
//        if (login_email.text.toString().isEmpty()) {
//            login_email.error = "Please enter email"
//            login_email.requestFocus()
//            return
//        }
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(login_email.text.toString()).matches()) {
//            login_email.error = "Please enter a valid email"
//            login_email.requestFocus()
//            return
//        }
//
//        if (login_password.text.toString().isEmpty()) {
//            login_password.error = "Please enter password"
//            login_password.requestFocus()
//            return
//        }
//
//        auth.signInWithEmailAndPassword(login_email.text.toString(), login_password.text.toString())
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    updateUI(null)
//                }
//            }
    }

}