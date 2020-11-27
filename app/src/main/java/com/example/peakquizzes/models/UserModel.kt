package com.example.peakquizzes.models

import com.google.firebase.firestore.Exclude

class UserModel {
    public data class User (var name: String, var username: String, var email: String, var type: String) {
    }
}