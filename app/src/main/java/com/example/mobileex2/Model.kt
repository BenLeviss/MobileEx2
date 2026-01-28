package com.example.mobileex2

class Model private constructor() {
    val Students = mutableListOf<Student>()

    init {
        // some data so list wont be empty
        for (i in 0..30) {
            Students.add(Student("Student $i", "$i", "054-000000$i", "Address $i", false))
        }
    }

    companion object{
        val shared = Model()
    }
}