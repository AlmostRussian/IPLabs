package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen2()
        }
    }
}

@Composable
fun Screen2(myViewModel: MyViewModel3 = viewModel()) {
    val i by myViewModel.i
    Text(
        text = "Клики: $i",
        modifier = Modifier.clickable(onClick = myViewModel::increment)
    )
}

class MyViewModel2 : ViewModel() {
    private val j = mutableStateOf(0)
    val i: State<Int> = j
    fun increment() {
        j.value++
    }
}

class MyViewModel3 : ViewModel() {
    var i = mutableStateOf(0)
        private set
    fun increment() {
        i.value++
    }
}