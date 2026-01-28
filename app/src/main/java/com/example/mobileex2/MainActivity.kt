package com.example.mobileex2

import StudentRecyclerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.adapter = StudentRecyclerAdapter(Model.shared.Students)

        findViewById<FloatingActionButton>(R.id.add_student_fab).setOnClickListener {
            startActivity(Intent(this, new_student::class.java))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        findViewById<RecyclerView>(R.id.students_recycler_view).adapter?.notifyDataSetChanged()
    }
}