package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val count = remember{mutableStateOf(0)}

            Text("Clicks: ${count.value}",
                fontSize = 28.sp,
                modifier = Modifier.clickable( onClick = { count.value += 1 })
            )
        }
    }
}