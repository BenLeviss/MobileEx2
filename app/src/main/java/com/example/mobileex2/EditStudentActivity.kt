package com.example.mobileex2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileex2.databinding.ActivityEditStudentBinding

class EditStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStudentBinding
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentId = intent.getStringExtra("id")

        student = Model.shared.Students.find { it.id == studentId }

        student?.let { s ->
            binding.editStudentNameEt.setText(s.name)
            binding.editStudentIdEt.setText(s.id)
            binding.editStudentPhoneEt.setText(s.phone)
            binding.editStudentAddressEt.setText(s.address)
            binding.editStudentCheckedCb.isChecked = s.isChecked

            binding.btnSave.setOnClickListener {
                saveStudent()
            }

            binding.tvDelete.setOnClickListener {
                Model.shared.Students.remove(student)
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }

            binding.btnCancel.setOnClickListener {
                finish()
            }
        }
    }

    private fun saveStudent() {
        val name = binding.editStudentNameEt.text.toString()
        val id = binding.editStudentIdEt.text.toString()
        val phone = binding.editStudentPhoneEt.text.toString()
        val address = binding.editStudentAddressEt.text.toString()
        val isChecked = binding.editStudentCheckedCb.isChecked

        if (name.isEmpty()) {
            binding.editStudentNameEt.error = "Enter name"
            return
        }

        if (id.isEmpty()) {
            binding.editStudentIdEt.error = "Enter ID"
            return
        }

        if (phone.isEmpty()) {
            binding.editStudentPhoneEt.error = "Enter phone"
            return
        }

        if (address.isEmpty()) {
            binding.editStudentAddressEt.error = "Enter address"
            return
        }

        student?.apply {
            this.name = name
            this.id = id
            this.phone = phone
            this.address = address
            this.isChecked = isChecked
        }

        finish()
    }
}
