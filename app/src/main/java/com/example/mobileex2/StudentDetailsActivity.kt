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
    private lateinit var student: Student
    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)

        val backBtn: Button = findViewById(R.id.btn_back)
        val editBtn: Button = findViewById(R.id.details_edit_btn)

        position = intent.getIntExtra("student_position", -1)

        if (position == -1) {
            finish()
            return
        }

        editBtn.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("id", student.id)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        student = Model.shared.Students.getOrNull(position) ?: return

        val nameTv: TextView = findViewById(R.id.details_name)
        val idTv: TextView = findViewById(R.id.details_id)
        val phoneTv: TextView = findViewById(R.id.details_phone)
        val addressTv: TextView = findViewById(R.id.details_address)
        val CheckBox: CheckBox = findViewById(R.id.details_checked)

        nameTv.text = "name: ${student.name}"
        idTv.text = "id: ${student.id}"
        phoneTv.text = "phone: ${student.phone}"
        addressTv.text = "address: ${student.address}"
        CheckBox.isChecked = student.isChecked
    }
}