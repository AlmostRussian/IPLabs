package com.example.p6

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.p6.ui.theme.UDFprinciple.Screen3UDF

class MainActivity : ComponentActivity() {
    private val TAG = "P10"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen3UDF()
            Log.d(TAG, "Код сработал")
        }
    }
}