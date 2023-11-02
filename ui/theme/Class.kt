package com.example.p6.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MyText1(i: State<Int>, lambdaForClick: () -> Unit) {
    val i = remember{ mutableStateOf(0) }
    Text("Clicks: ${i.value}",
        fontSize = 28.sp,
        modifier = Modifier.clickable( onClick = { i.value += 2 })
    )
}
