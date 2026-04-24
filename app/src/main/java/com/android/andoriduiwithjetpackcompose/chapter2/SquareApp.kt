package com.android.andoriduiwithjetpackcompose.chapter2

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SquareApp(){

    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(squareAsString(0)) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Text(
            modifier = Modifier.clickable {
                expanded = true
            },
            text = text,
            style = MaterialTheme.typography.h1
        )

        DropdownMenu(
                expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            for (n in 0 ..  20){
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        text = squareAsString(n)
                    }
                ) {
                    Text("${n.toString()}!")
                }
            }
        }

    }

}


fun squareAsString(n: Int): String {
    val result = n * n
    return "$n² = $result"
}

