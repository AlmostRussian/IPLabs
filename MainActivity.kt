package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var progress by remember { mutableStateOf(0.0f) }
            val scope = rememberCoroutineScope()

            Column{
                OutlinedButton(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        scope.launch {
                            while (progress < 1f) {
                                progress += 0.1f
                                delay(1000L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }

                LinearProgressIndicator(
                    progress = progress,
                    color = Color(0xFFD32F2F),
                    trackColor = Color.Gray,
                )
            }
        }
    }
}