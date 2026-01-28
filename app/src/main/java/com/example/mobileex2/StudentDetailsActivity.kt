package com.example.mobileex2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val position = intent.getIntExtra("student_position", -1)
        if (position != -1) {
            val student = Model.data[position]

            // Find the Views
            val nameTv: TextView = findViewById(R.id.details_name)
            val idTv: TextView = findViewById(R.id.details_id)
            val phoneTv: TextView = findViewById(R.id.details_phone)
            val addressTv: TextView = findViewById(R.id.details_address)
           // val checkBox: CheckBox = findViewById(R.id.details_check)
            val editBtn: Button = findViewById(R.id.details_edit_btn)

            nameTv.text = "name: ${student.name}"
            idTv.text = "id: ${student.id}"
            phoneTv.text = "phone: ${student.phone}"
            addressTv.text = "address: ${student.address}"
           // checkBox.isChecked = student.isChecked

            // Handle Edit button click
            editBtn.setOnClickListener {
                // val intent = Intent(this, EditStudentActivity::class.java)
                // intent.putExtra("student_position", position)
                // startActivity(intent)
            }
        }
    }
}