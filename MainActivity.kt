package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val checkedState = remember { mutableStateOf(ToggleableState.Indeterminate) }
            Row{
                TriStateCheckbox(
                    state = checkedState.value,
                    onClick = {
                        if (checkedState.value == ToggleableState.Indeterminate || checkedState.value == ToggleableState.Off)
                            checkedState.value = ToggleableState.On
                        else checkedState.value = ToggleableState.Off
                    },
                    modifier = Modifier.padding(5.dp),
                )
                Text("Выбрано", fontSize = 22.sp)
            }
        }
    }
}