package com.example.mobileex2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditStudentActivity : AppCompatActivity() {
    class EditStudentActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_edit_student)

            findViewById<Button>(R.id.btnCancel).setOnClickListener {
                finish()
            }

            findViewById<Button>(R.id.btnSave).setOnClickListener {
                // TODO: update student
                finish()
            }

            findViewById<TextView>(R.id.tvDelete).setOnClickListener {
                // TODO: delete student
                finish()
            }
        }
    }

}