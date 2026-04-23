package com.android.andoriduiwithjetpackcompose.chapter1.practice1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.android.andoriduiwithjetpackcompose.R


@Composable
@Preview
fun Modify(){


    val name = remember { mutableStateOf(" ") }
    val nameEntered = remember {mutableStateOf(false) }
    val showError = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){

        if(nameEntered.value){
            Greeting(name.value)
        }else{
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Welcome()
                TextAndButton(name, nameEntered, showError)

                if (showError.value){
                    Text(
                        text = stringResource(id = R.string.error),
                        color = MaterialTheme.colors.error
                    )
                }


            }
        }
        
    }

}

@Composable
@Preview(group = "my-group-1", device = Devices.AUTOMOTIVE_1024p)
fun GreetingWrapper(){
Greeting("JetPack Compose")
}

@Composable
fun Greeting(name: String){
    Text(
        text = stringResource(id= R.string.hello, name),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
@Preview(group = "my-group-1")
fun AltGreeting(name: String = "Jetpack Compose"){

    Text(
        text = stringResource(R.string.hello, name),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )


}

class HelloProvider: PreviewParameterProvider<String>{
    override val values: Sequence<String>
        get() = listOf("PreviewParameterProvider").asSequence()
}

@Composable
@Preview
fun AltGreeitng2(@PreviewParameter(HelloProvider::class)
name: String){

    Text(
        text = stringResource(id = R.string.hello, name),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
@Preview(locale = "de-rDE")
fun Welcome(){
    Text(
        text = stringResource(id = R.string.welcome),
        style = MaterialTheme.typography.subtitle1
    )
}


@Composable
fun TextAndButton(
    name: MutableState<String>,
    nameEntered : MutableState<Boolean>,
    showError: MutableState<Boolean>

){

    Row(
        modifier = Modifier.padding(8.dp)
    ) {

        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
                showError.value = false
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.hint)
                )
            },

            modifier = Modifier
                .alignByBaseline()
                .weight(1.0f),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                capitalization = KeyboardCapitalization.Words,
            ),
            keyboardActions = KeyboardActions(onAny = {
                    if (name.value.isNotEmpty()){
                        nameEntered.value = true
                    }else{
                        showError.value = true
                    }
            })
        )

        Button(
            modifier = Modifier
                .alignByBaseline()
                .padding(8.dp),
            onClick = {
                if (name.value.isNotEmpty()){
                    nameEntered.value = true
                }else{
                    showError.value = true
                }
            }
        ) {
            Text(text = stringResource(id = R.string.done))
        }

    }

}



