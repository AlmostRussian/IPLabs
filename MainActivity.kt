package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var expanded by remember { mutableStateOf(false) }
            var selectedOption by remember { mutableStateOf("") }
            Column{
                Text("Выбран пункт: $selectedOption")
                Box {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Показать меню")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Скопировать") },
                            onClick = { selectedOption="Copy" },
                        )
                        DropdownMenuItem(
                            text = { Text("Вставить") },
                            onClick = { selectedOption="Paste" },
                        )
                        Divider()
                        DropdownMenuItem(
                            text = { Text("Настройки") },
                            onClick = { selectedOption="Settings" },
                        )
                    }
                }
            }

        }
    }
}