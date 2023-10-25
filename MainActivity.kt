package com.example.p6_kotlininteraction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                val createMessage = {hour: Int ->
                    if (hour > 18) {
                        "Добрый вечер"
                    } else if (hour > 10) {
                        "Добрый день"
                    } else {
                        "Доброе утро"
                    }
                }

                Text(text = createMessage(5), fontSize = 28.sp)
                Text(text = createMessage(15), fontSize = 28.sp)
                Text(text = createMessage(19), fontSize = 28.sp)
            }
        }
    }
}