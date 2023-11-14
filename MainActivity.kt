package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen0()
        }
    }
}

@Composable
fun Screen0(myViewModel: MyViewModel = viewModel()) {
    var i by remember { mutableStateOf(0) }
    Text(
        text = "Клики: $i",
        modifier = Modifier.clickable(onClick = { i++ } )
    )
}

class MyViewModel : ViewModel() {
    val i = mutableStateOf(0)
}