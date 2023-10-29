package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val label = remember{mutableStateOf("Click")}
            Button(onClick = {label.value = "Hello"}){
                Text(label.value, fontSize = 25.sp)
            }
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(contentColor = Color.Red)
            )
            {
                Text("Click", fontSize = 25.sp)
            }
        }
    }
}


