package com.android.andoriduiwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.ExperimentalComposeUiApi

import com.android.andoriduiwithjetpackcompose.chapter3.ModifierDemoApp
import com.android.andoriduiwithjetpackcompose.chapter4.ConstraintDemo

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            ModifierDemoApp()

            ConstraintDemo()

        }

    }
}

