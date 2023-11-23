package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
class MainActivity : ComponentActivity() {
    val randomSizedPhotos = listOf(
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 900, height = 1600),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 300, height = 400),
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 900, height = 1600),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 300, height = 400),
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 500, height = 500),

        randomSampleImageUrl(width = 900, height = 1600),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 300, height = 400),
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 300, height = 400),
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 900, height = 1600),
        randomSampleImageUrl(width = 500, height = 500),
        randomSampleImageUrl(width = 300, height = 400),
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 500, height = 500),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                itemsIndexed(randomSizedPhotos) { i, it ->
                    Box(
                        //пока что Box вместо AsyncImage
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
        }
    }
}

fun randomSampleImageUrl(
    seed: Int = (0..100000).random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}

@Composable
fun rememberRandomSampleImageUrl(
    seed: Int = (0..100000).random(),
    width: Int = 300,
    height: Int = width,
): String = remember { randomSampleImageUrl(seed, width, height) }