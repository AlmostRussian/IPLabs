package com.example.p6.ui.theme

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun MutableStateInsideComposableWithoutRemember(){
    var checkedState = remember { mutableStateOf(false) }
    var checkedValue = checkedState.value
    Column {
        Row(verticalAlignment = Alignment.Top){
            Checkbox(checked = checkedValue, onCheckedChange = {value -> checkedState.value = value})
            Text("Текст ...", fontSize = 30.sp, color = Color.Magenta)
        }
        if(checkedValue){
            Text(text = "Много какого-то текста... ", fontSize = 25.sp, color = Color.Cyan)
        }
    }
}