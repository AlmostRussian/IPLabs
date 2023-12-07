package com.example.p6.ui.theme

import androidx.compose.runtime.toMutableStateList
import com.github.javafaker.Faker
import androidx.lifecycle.ViewModel
import kotlin.random.Random

data class Student(
    val name: String,
    val grade: Int
)

class MyViewModel : ViewModel() {
    val students: MutableList<Student> = (1..10).map {
        Student(
            Faker().name().name(),
            Faker().random().nextDouble().let {
                Random.nextInt(0, 10)
            }
        )
    }.toMutableStateList()
}