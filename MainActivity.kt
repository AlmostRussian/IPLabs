package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen1()
        }
    }
}


@Composable
fun Screen1(myViewModel: MyViewModel1 = viewModel()) {
    var i by myViewModel.i
    Text(
        text = "Клики: $i",
        modifier = Modifier.clickable(onClick = { i++ } )
    )
}


class MyViewModel1 : ViewModel() {
    val i = mutableStateOf(0)
}