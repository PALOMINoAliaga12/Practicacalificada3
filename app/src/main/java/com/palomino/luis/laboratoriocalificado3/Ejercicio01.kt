package com.palomino.luis.laboratoriocalificado3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.palomino.luis.laboratoriocalificado3.databinding.ActivityEjercicio01Binding
import com.palomino.luis.laboratoriocalificado3.ui.TeacherAdapter
import com.palomino.luis.laboratoriocalificado3.viewmodel.TeacherViewModel

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding
    private val viewModel: TeacherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.teachers.observe(this, { teachers ->
            binding.recyclerView.adapter = TeacherAdapter(this, teachers)
        })

        viewModel.fetchTeachers()
    }
}

