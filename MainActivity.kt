package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Image(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Значок электронной почты",
                    modifier = Modifier.size(200.dp, 150.dp)
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_background),
                    contentDescription = "Android"
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = "Красная звезда"
                )
            }
        }
    }
}