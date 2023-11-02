package com.example.p6

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var scaffoldState = rememberScaffoldState()
            var scope = rememberCoroutineScope()

            Scaffold(
                scaffoldState = scaffoldState,
                drawerContent={
                    Text("Пункт меню 1", fontSize = 28.sp)
                    Text("Пункт меню 2", fontSize = 28.sp)
                    Text("Пункт меню 3", fontSize = 28.sp)
                }
            ){
                Button(onClick = {
                    scope.launch{
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Text("Меню", fontSize = 28.sp)
                }
            }
        }
    }
}
