package com.example.p6.ui.theme

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxinDaRow() {
    var context = LocalContext.current
    var checkState by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Red, RoundedCornerShape(10.dp))
                .clickable {
                    Toast
                        .makeText(context, "Клик на строке ...", Toast.LENGTH_SHORT)
                        .show()
                    var checkedState = !checkState
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Checkbox(checked = checkState, onCheckedChange = {
                checkState = it
                if (checkState){
                    Toast.makeText(context, "Чекбокс нажат", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Чекбокс не нажат", Toast.LENGTH_SHORT).show()
                }
            }
            )
            Text(text = "Нажимая на строку, регулируешь чекбокс")
        }
}