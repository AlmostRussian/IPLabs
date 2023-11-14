package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {
    val viewModel: MyViewModel1 by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val i=viewModel.i
        super.onCreate(savedInstanceState)
        setContent {
            Screen(i)
        }
    }
}

@Composable
fun Screen(i: MutableState<Int>) {
    Text(
        text = "Клики: ${ i.value}",
        modifier = Modifier.clickable(onClick = { i.value++ } )
    )
}

class MyViewModel1 : ViewModel() {
    val i = mutableStateOf(0)
}