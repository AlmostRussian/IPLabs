package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val added = remember{ mutableStateOf(false)}
            ExtendedFloatingActionButton(
                icon = {
                    Icon(
                        if(added.value) Icons.Filled.Delete else Icons.Filled.Add,
                        contentDescription = "Добавить"
                    ) },
                text = { Text(if(added.value) "Удалить" else "Добавить") },
                onClick = {added.value = !added.value}
            )
        }
    }
}