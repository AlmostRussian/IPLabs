package com.example.p6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen(viewModel)
        }
    }
}

@Composable
fun Screen(viewModel: MyViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ClickableCounter(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedCounter(viewModel)
    }
}

@Composable
fun ClickableCounter(viewModel: MyViewModel) {
    var clickCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                clickCount++
                viewModel.onCounterClick()
            }
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Text(
            text = "Clicks: $clickCount",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
        )
    }
}
@Composable
fun AnimatedCounter(viewModel: MyViewModel) {
    var animatedClickCount by remember { mutableStateOf(0) }

    val animatedValue by animateFloatAsState(
        targetValue = animatedClickCount.toFloat(),
        animationSpec = androidx.compose.animation.core.spring()
    )

    LaunchedEffect(key1 = animatedClickCount) {
        viewModel.onAnimatedCounterChange(animatedClickCount)
        // Добавляем небольшую задержку, чтобы увидеть анимацию
        delay(100)
        viewModel.onAnimatedCounterDispose()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                animatedClickCount++
            }
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        Text(
            text = "Animated Clicks: ${animatedValue.toInt()}",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
        )
    }
}

class MyViewModel : ViewModel() {
    fun onCounterClick() {

    }

    fun onAnimatedCounterChange(animatedClickCount: Int) {

    }

    fun onAnimatedCounterDispose() {

    }
}

@Preview
@Composable
fun PreviewScreen() {
    MaterialTheme {
        Screen(MyViewModel())
    }
}