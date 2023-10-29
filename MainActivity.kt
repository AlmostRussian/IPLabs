package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
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
            val colors = listOf(
                ColorData("красный", Color.Red),
                ColorData("зеленый", Color.Green),
                ColorData("синий", Color.Blue))
            val selectedOption = remember { mutableStateOf(colors[0]) }
            Column(modifier =Modifier.padding(20.dp)) {
                Box( Modifier.padding(10.dp).size(100.dp).background(color = selectedOption.value.color))

                colors.forEach { colorData ->
                    val selected = selectedOption.value == colorData
                    Row(modifier = Modifier.selectable(
                        selected = selected,
                        onClick = { selectedOption.value = colorData }),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Box(
                            Modifier.padding(8.dp)
                                .size(60.dp)
                                .background(color = colorData.color)
                                .border(
                                    width= if(selected){2.dp} else{0.dp},
                                    color = Color.Black
                                )
                        )
                        Text(text = colorData.title, fontSize = 22.sp)
                    }
                }
            }
        }
    }
}
data class ColorData(val title:String, val color: Color)