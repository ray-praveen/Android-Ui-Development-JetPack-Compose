package com.android.andoriduiwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.andoriduiwithjetpackcompose.chapter1.greetingUser.Hello
import com.android.andoriduiwithjetpackcompose.chapter1.practice1.Modify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Hello()
            Modify()
        }
    }
}

