package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(
                text="Hello METANIT.COM",
                fontSize= 26.sp,
                color = colorResource(R.color.textViewFontColor),
                modifier = Modifier.padding(20.dp)
                    .fillMaxWidth()
                    .background(colorResource(R.color.textViewBackColor))
                    .padding(50.dp)
            )
        }
    }
}