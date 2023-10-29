package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var progress by remember { mutableStateOf(0.0f) }
            val scope = rememberCoroutineScope()

            Column{
                Text("Статус: $progress", fontSize = 22.sp)
                OutlinedButton(
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
                CircularProgressIndicator(progress = progress)
            }
            onClick = {
                scope.launch {
                    while (progress < 1f) {
                        progress += 0.1f
                        delay(1000L)
                    }
                }
            }
            Box{ CircularProgressIndicator() }

            var progress by remember { mutableStateOf(0.0f) }
            val scope = rememberCoroutineScope()

            Column{
                Text("Статус: $progress", fontSize = 22.sp)
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

                LinearProgressIndicator(progress = progress)
            }

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
                    backgroundColor = Color(0xFFEF9A9A)
                )
            }

            Column{
                LinearProgressIndicator(modifier = Modifier.padding(20.dp))
            }
        }
        super.onCreate(savedInstanceState)
    }
}