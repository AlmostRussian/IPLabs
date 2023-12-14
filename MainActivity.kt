package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val items = listOf("Меню", "О нас", "FAQ")
    val selectedItem = remember{ mutableStateOf("")}
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                for (item in items) {
                    Text(
                        item,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.clickable {
                            selectedItem.value = item
                        }
                    )
                }
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Меню ресторана")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Чтобы сделать заказ, нажмите на соответствующую кнопку в правом нижнем углу экрана!",
                    )
                }
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            floatingActionButton = {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    ExtendedFloatingActionButton(
                        modifier = Modifier.width(255.dp),
                        text = { Text("Сделать заказ") },
                        icon = { Icon(Icons.Filled.Check, contentDescription = "Вызов") },
                        onClick = {
                            presses++
                            if (presses > 3){
                                scope.launch {
                                    snackbarHostState.showSnackbar("Вам будет предоставлено кофе за счет заведения")
                                }
                            } else{
                                scope.launch {
                                    snackbarHostState.showSnackbar("Вы вызвали официанта")
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    ExtendedFloatingActionButton(
                        text = { Text("Открыть меню приложения") },
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Меню") },
                        onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                    """
                        Первые блюда
                        Борщ
                        Солянка
                        Крем-суп
                        
                        Вторые блюда
                        Гречка с мясом
                        Макароны по-флотски
                        Жаренная курица с рисом
                        
                        Напитки
                        Чай
                        Кофе
                        Мартини
                        Эспрессо
                        
                        
                        
                        Вы вызвали сотруника $presses раз. Если сотрудник не подошел спустя 3 минуты и 3 раз вызова, мы предоставим Вам кофе за счет заведения.
                    """.trimIndent(),
                )
            }
        }
    }
}