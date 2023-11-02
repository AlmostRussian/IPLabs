package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBar(title = {
            },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Меню")
                    }

                    Row {
                        Spacer(Modifier.weight(1f, true))
                        Text("METANIT.COM", fontSize = 22.sp)
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Search, contentDescription = "Поиск")
                        }
                    }
            })
        }
    }
}