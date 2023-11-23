package com.example.p6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.javafaker.Faker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

@Composable
fun CityItem(text: String) {
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))
}

@SuppressLint("RememberReturnType")
@Composable
fun MyScreen() {
    val faker = Faker()
    val citiz = remember {
        (1..50).map{ faker.address().city() }.toMutableStateList()
    }
    Column(modifier = Modifier.verticalScroll(ScrollState(0), true)) {
        TextButton(onClick = { citiz.add(faker.address().city()) }) {
            CityItem("+")
        }
        citiz.forEach {
            key(it) { CityItem(it) }
        }
    }
}