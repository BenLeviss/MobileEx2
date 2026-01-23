package com.example.mobileex2

object Model {
    val data = mutableListOf<Student>()

    init {
        // some data so list wont be empty
        for (i in 0..30) {
            data.add(Student("Student $i", "$i", "054-000000$i", "Address $i", false))
        }
    }
}