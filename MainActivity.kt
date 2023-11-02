package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val checkedState = remember { mutableStateOf(false) }
            val textColor = remember { mutableStateOf(Color.Unspecified) }
            Column(modifier = Modifier.fillMaxSize().padding(10.dp)){
                Row (verticalAlignment = Alignment.CenterVertically ){
                    Text("Красный цвет", fontSize = 22.sp, color = textColor.value)
                    Switch(
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            if(checkedState.value) textColor.value = Color(0xFFC62828)
                            else textColor.value = Color.Unspecified
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFFC62828),
                            checkedTrackColor = Color(0xFFE57373),
                            uncheckedThumbColor = Color(0xFFEF9A9A),
                            uncheckedTrackColor = Color(0xFFFFEBEE)
                        )
                    )
                }
            }
        }
    }
}