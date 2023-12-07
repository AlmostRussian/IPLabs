package com.example.p6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.javafaker.Faker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var data by remember { mutableStateOf(emptyList<DataEntry>()) }
    val coroutineScope = rememberCoroutineScope()

    val database = AppDatabase(context = LocalContext.current)

    SideEffect {
        database.insertData("Admin", "admin@mail.ru")
    }

    LaunchedEffect(true) {
        coroutineScope.launch {
            while (true) {
                val faker = Faker()
                val name = faker.name().fullName()
                val email = faker.internet().emailAddress()

                database.insertData(name, email)

                data = database.getAllData()

                delay(1500) // Wait for 5 seconds before generating the next set of data
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Faker + SQLite Example") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Generated Data:")
                Spacer(modifier = Modifier.height(8.dp))

                data.forEach { entry ->
                    Text("Name: ${entry.name}, Email: ${entry.email}")
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    MyApp()
}