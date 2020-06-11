package com.kip.receiptscanner

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kip.receiptscanner.checklist.ChecklistActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScannerAndroidTest {
    @Rule
    @JvmField
    val rule: ActivityTestRule<MainTextRecognizer> = ActivityTestRule(MainTextRecognizer::class.java)

    @Test
    fun recognize_text_correct() {
        // Set image
//        rule.activity.imageView.setImageResource(R.drawable.receipt)

        // Click on add button
//        onView(withId(R.id.recognizeText)).perform(click())
//
//        var editText1 = rule.activity.findViewById(R.id.editText) as EditText
//        var text1:String = editText1.text.toString()

    }

}