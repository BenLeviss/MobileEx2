package com.example.mobileex2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileex2.databinding.ActivityNewStudentBinding

class new_student : AppCompatActivity() {
    private lateinit var binding: ActivityNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            saveStudent()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveStudent () {

        val name = binding.addNewStudentNameEt.text.toString()
        val id = binding.addNewStudentIdEt.text.toString()
        val phone = binding.addNewStudentPhoneEt.text.toString()
        val address = binding.addNewStudentAddressEt.text.toString()
        val isChecked = binding.addNewStudentCheckboxCb.isChecked

        if (name.isEmpty()) {
            binding.addNewStudentNameEt.error = "Enter name"
            return
        }

        if (id.isEmpty()) {
            binding.addNewStudentIdEt.error = "Enter student ID"
            return
        }

        if (phone.isEmpty()) {
            binding.addNewStudentPhoneEt.error = "Enter phone number"
            return
        }

        if (address.isEmpty()) {
            binding.addNewStudentAddressEt.error = "Enter address"
            return
        }

        val student = Student(
            name = name,
            id = id,
            phone = phone,
            address = address,
            isChecked = isChecked
        )

        Model.shared.Students.add(student)

        finish()
    }
}