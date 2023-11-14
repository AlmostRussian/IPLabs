package com.example.p6.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

object UDFprinciple {
    @Composable
    fun Screen3UDF(
        myViewModel: MyViewModel2 = viewModel()
    ) {
        val i by myViewModel.i
        increment(i, myViewModel::increment)
    }
    @Composable
    fun increment(
        i: Int,
        increment: () -> Unit
    ) {
        Text(
            text = "Клики: $i",
            modifier = Modifier.clickable(onClick = increment)
        )
    }
}

class MyViewModel2 : ViewModel() {
    var i = mutableStateOf(0)
        private set
    fun increment() {
        i.value++
    }
}
