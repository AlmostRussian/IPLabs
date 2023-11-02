package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Image(
                painter = BitmapPainter(ImageBitmap.imageResource(R.drawable.forest)),
                contentDescription = "Зимний лес"
            )
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.forest),
                contentDescription = "Зимний лес"
            )
        }
    }
}