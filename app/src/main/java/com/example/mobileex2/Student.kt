package com.example.mobileex2

// This represents a single student
data class Student(
    var name: String,
    var id: String,
    var phone: String,
    var address: String,
    var isChecked: Boolean = false
)