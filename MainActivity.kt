package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()){
            BottomAppBar {
                IconButton(onClick = {  }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Меню")
                }
                Spacer(Modifier.weight(1f, true))

                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Search, contentDescription = "Избранное")
                }
            }
        }}
    }
}