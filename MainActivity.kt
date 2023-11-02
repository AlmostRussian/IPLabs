package com.example.p6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isAdded = remember{ mutableStateOf(false) }
            Scaffold(
                bottomBar = {
                    BottomAppBar{
                        IconButton(onClick = {  }) { Icon(Icons.Filled.Menu, contentDescription = "Меню")}
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = {  }) { Icon(Icons.Filled.Search, contentDescription = "Поиск")}
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        content = {
                            if(isAdded.value) Icon(Icons.Filled.Clear, contentDescription = "Удалить")
                            else Icon(Icons.Filled.Add, contentDescription = "Добавить") },
                        onClick = { isAdded.value = !isAdded.value}
                    )
                },
                floatingActionButtonPosition = FabPosition.Center,
            ){
                Text(if(isAdded.value) "Товар добавлен" else "Корзина пуста", fontSize = 28.sp)
            }
        }
    }
}