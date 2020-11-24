package com.example.peakquizzes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.junit.Test

class LoginActivityTest {
    @Test
    fun button_appears_with_correct_text() {
        onView(allOf(withId(R.id.button_register)))
            .check(matches(withText("Let's go!")))
    }
}