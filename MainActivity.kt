package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val checked = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically){
                IconToggleButton(checked = checked.value, onCheckedChange = { checked.value = it }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Информация о приложении",
                        tint = if (checked.value) Color(0xFFEC407A) else Color(0xFFB0BEC5)
                    )
                }
                Text(
                    text = if(checked.value) "Выбрано" else "Не выбрано",
                    fontSize = 28.sp
                )
            }
        }
    }
}