package com.example.peakquizzes.activities

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.peakquizzes.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginActivity: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        val redirect_to_register_button: Button = findViewById(R.id.button_register_redirect)
        redirect_to_register_button.setOnClickListener{
            redirectUser()
        }

        val login_button: Button = findViewById(R.id.button_login)
        login_button.setOnClickListener{
            loginUser()
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }



        private fun redirectUser() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun loginUser() {
        val login_email: TextView = findViewById(R.id.login_email)
        val login_password: TextView = findViewById(R.id.login_password)

        if (login_email.text.toString().isEmpty()) {
            login_email.error = "Please enter email"
            login_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(login_email.text.toString()).matches()) {
            login_email.error = "Please enter a valid email"
            login_email.requestFocus()
            return
        }

        if (login_password.text.toString().isEmpty()) {
            login_password.error = "Please enter password"
            login_password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(login_email.text.toString(), login_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null ) {
            if(currentUser.isEmailVerified) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(
                    baseContext, "Please verify your email address.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                baseContext, "We could not automatically log you in at this time, please login",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}