package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    val randomSizedPhotos = listOf("...")
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 200.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                itemsIndexed(randomSizedPhotos) { i, it ->
                    Box(
                        Modifier
                            .padding(3.dp)
                            .fillMaxWidth()
                            .height(20.dp * i)
                            .background(Color.Cyan),
                    ) {
                        Column {
                            Text(text = "$i + ${it.toString()}")
                        }
                    }
                }
            }
            LazyVerticalStaggeredGridSample()
        }
    }
}

@Composable
fun LazyVerticalStaggeredGridSample() {
    val itemsList = (0..5).toList()
    val itemsIndexedList = listOf("A", "B", "C")

    val itemModifier = Modifier
        .border(1.dp, Color.Blue)
        .wrapContentSize()

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(200.dp)
    ) {
        items(itemsList) {
            Text("Item is $it", itemModifier.height(80.dp))
        }
        item {
            Text("Single item", itemModifier.height(100.dp))
        }
        itemsIndexed(itemsIndexedList) { index, item ->
            Text("Item at index $index is $item", itemModifier.height(60.dp))
        }
    }
}