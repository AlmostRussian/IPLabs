package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextIndent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Hello Jetpack Compose!", fontSize=25.sp, letterSpacing= 1.3.sp)
                Text(text = "Hello Jetpack Compose!", fontSize=5.em, letterSpacing= 1.3.em)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, color=Color.Red)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp,
                    color= Color(red = 0x44, green = 0x55, blue = 0x88, alpha = 0xFF))
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontStyle = FontStyle.Italic)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontStyle = FontStyle.Normal)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontWeight= FontWeight.Bold)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontWeight= FontWeight.W700)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontWeight= FontWeight(700))
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Cursive)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Monospace)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.SansSerif)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Serif)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Default)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, textDecoration = TextDecoration.LineThrough)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, textDecoration = TextDecoration.Underline)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, textDecoration = TextDecoration.None)
                Text(text = "Hello (Center)", modifier = Modifier.fillMaxWidth(1f) ,  fontSize=22.sp, textAlign = TextAlign.Center)
                Text(text = "Hello (Justify)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Justify)
                Text(text = "Hello (Left)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Left)
                Text(text = "Hello (Right)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Right)
                Text(text = "Hello (Start)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Start)
                Text(text = "Hello (End)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.End)
                Text(
                    text = "Все мы сейчас желаем кушать, потому что утомились",
                    fontSize = 22.sp,
                    style = TextStyle(textGeometricTransform = TextGeometricTransform(0.5f))
                )
                Text(
                    text = "Все мы сейчас желаем кушать, потому что утомились",
                    fontSize = 22.sp,
                    style = TextStyle(textGeometricTransform = TextGeometricTransform(1.5f))
                )
                Text(
                    text = "Hello Metanit.com",
                    fontSize = 30.sp,
                    style = TextStyle(shadow = Shadow(Color.LightGray , Offset(10.0f, 16.5f), 1.0f))
                )
                Text(
                    text = "Все мы сейчас желаем кушать, потому что утомились",
                    fontSize=22.sp,
                    style = TextStyle(textDirection = TextDirection.Rtl)
                )
                Text(
                    text = "Все мы сейчас желаем кушать, потому что утомились и уже четвертый час",
                    fontSize = 22.sp,
                    style = TextStyle(textIndent = TextIndent(50.sp, 25.sp))
                )
            }
        }
    }
}