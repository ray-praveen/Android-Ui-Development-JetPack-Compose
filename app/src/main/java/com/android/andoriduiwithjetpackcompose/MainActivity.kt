package com.android.andoriduiwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.andoriduiwithjetpackcompose.chapter1.greetingUser.Hello
import com.android.andoriduiwithjetpackcompose.chapter1.practice1.Modify
import com.android.andoriduiwithjetpackcompose.chapter2.Factorial
import com.android.andoriduiwithjetpackcompose.chapter2.SquareApp
import com.android.andoriduiwithjetpackcompose.chapter3.ColorPickerApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Hello()
//            Factorial()
//            SquareApp()
            ColorPickerApp()
        }
    }
}

