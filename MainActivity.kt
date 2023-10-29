package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var checked = remember { mutableStateOf(false) }
            Text(
                modifier = Modifier.toggleable(value = checked.value, onValueChange = { checked.value = it }),
                text = checked.value.toString(),
                fontSize = 30.sp
            )
        }
    }
}