package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.javafaker.Faker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val faker = Faker()
        val citiz: MutableList<City> =
            (1..100).map {
                City(
                    faker.address().city(),
                    String.format("%.1f", faker.random().nextDouble()).toDouble()
                )
            }.toMutableStateList()
        setContent {
            MyScreen(citiz)
        }
    }
}
@Composable
fun CityItem(cityModel: City) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(), elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = cityModel.name,

                modifier = Modifier.fillMaxWidth(0.7f),

                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Text(text = cityModel.temp.toString(), fontSize = 20.sp, textAlign = TextAlign.Right)
        }
    }
}

@Composable
fun MyScreen(citiz: List<City>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .border(3.dp, Color.Gray)
            .padding(10.dp)

    ) {
        items(citiz) {
            CityItem(it)
        }
    }
}

data class City(
    val name: String,
    val temp: Double
)
