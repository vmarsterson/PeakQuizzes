package com.example.peakquizzes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.peakquizzes.R
import com.example.peakquizzes.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}