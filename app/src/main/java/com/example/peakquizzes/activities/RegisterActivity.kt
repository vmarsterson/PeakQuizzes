package com.example.peakquizzes.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.peakquizzes.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


lateinit var auth: FirebaseAuth
class RegisterActivity: AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var TAG = "Registration"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        auth = FirebaseAuth.getInstance()

        val redirectToLoginButton: Button = findViewById(R.id.button_login_redirect)
        redirectToLoginButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.button_register)
        registerButton.setOnClickListener{
            registerUser()
        }
    }

    private fun registerUser() {
        val registerNameInput: TextView = findViewById(R.id.register_name)
        val registerUsernameInput: TextView = findViewById(R.id.register_username)
        val registerEmailInput: TextView = findViewById(R.id.register_email)
        val registerPasswordInput: TextView = findViewById(R.id.register_password)

        val registerName = registerNameInput.text.toString()
        val registerUsername = registerUsernameInput.text.toString()
        val registerEmail = registerEmailInput.text.toString()
        val registerPassword = registerPasswordInput.text.toString()

        if (registerName.isEmpty()) {
            registerNameInput.error = "Please enter name"
            registerNameInput.requestFocus()
            return
        }

        if (registerUsername.isEmpty()) {
            registerUsernameInput.error = "Please enter username"
            registerUsernameInput.requestFocus()
            return
        }

        if (registerEmail.isEmpty()) {
            registerEmailInput.error = "Please enter email"
            registerEmailInput.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(registerEmail).matches()) {
            registerEmailInput.error = "Please enter valid email"
            registerEmailInput.requestFocus()
            return
        }

        if (registerPasswordInput.text.toString().isEmpty()) {
            registerPasswordInput.error = "Please enter password"
            registerPasswordInput.requestFocus()
            return
        }
        else {
            saveUserData()

            auth.createUserWithEmailAndPassword(
                registerEmail,
                registerPassword
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                    val d = Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
//                    updateUI(user)
                        user!!.sendEmailVerification()
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(
                                        baseContext,
                                        "Please check your email to verify your account.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)                    }
                    else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)                    }
                        Toast.makeText(
                            baseContext, "Sign Up failed. Please come back later.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    private fun saveUserData(){
        val registerNameInput: TextView = findViewById(R.id.register_name)
        val registerUsernameInput: TextView = findViewById(R.id.register_username)
        val registerEmailInput: TextView = findViewById(R.id.register_email)

        val registerName = registerNameInput.text.toString()
        val registerUsername = registerUsernameInput.text.toString()
        val registerEmail = registerEmailInput.text.toString()

        val user: MutableMap<String, Any> = hashMapOf(
            "name" to registerName,
            "username" to registerUsername,
            "email" to registerEmail
        )

        db
            .collection("users")
            .document()
            .set(user)
            .addOnSuccessListener { Toast.makeText(
                this@RegisterActivity,
                "Registered new user",
                Toast.LENGTH_LONG
            ).show() }
            .addOnFailureListener { Toast.makeText(
                this@RegisterActivity,
                "Failed to registered new user, please try again",
                Toast.LENGTH_LONG
            ).show() }
    }

}