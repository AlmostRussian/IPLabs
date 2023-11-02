package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sliderPosition by remember{mutableStateOf(0f)}
            Column{
                Text(text = "Текущее значение: ${sliderPosition}", fontSize = 22.sp)
                Slider(
                    value = sliderPosition,
                    valueRange = 0f..10f,
                    steps = 9,
                    onValueChange = { sliderPosition = it },
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFFB71C1C),
                        activeTrackColor = Color(0xFFEF9A9A),
                        inactiveTrackColor = Color(0xFFFFEBEE),
                        inactiveTickColor = Color(0xFFEF9A9A),
                        activeTickColor = Color(0xFFB71C1C)
                    )
                )
            }
        }
    }
}