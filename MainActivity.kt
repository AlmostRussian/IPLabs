package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.p6.bottom_navigation.MainScreen
import com.example.p6.ui.theme.P6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P6Theme {
                MainScreen()
            }
        }
    }
}