package com.example.p6_box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box( modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center )
            {
                Box(modifier = Modifier.background(Color.Blue).size(300.dp))
                Box(modifier = Modifier.background(Color.LightGray).size(200.dp))
                Text("Hello METANIT.COM!", style = TextStyle(fontSize = 22.sp))
            }
        }
    }
}