package com.example.p6.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun CircleItem(){
    val counter = remember { mutableStateOf(0) }
    val color = remember { mutableStateOf(Color.Blue) }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                when(counter.value++){
                    10->color.value = Color.Red
                    11->color.value = Color.Green
                    12->color.value = Color.Blue
                    13->color.value = Color.Cyan
                    14->color.value = Color.LightGray
                    15->color.value = Color.Magenta
                }
            },
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            text = counter.value.toString(),
            style = TextStyle(fontSize = 20.sp, color = Color.White)
        )
    }
}