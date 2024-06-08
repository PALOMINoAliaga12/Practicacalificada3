package com.palomino.luis.laboratoriocalificado3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palomino.luis.laboratoriocalificado3.model.Teacher
import com.palomino.luis.laboratoriocalificado3.network.RetrofitClient
import kotlinx.coroutines.launch

class TeacherViewModel : ViewModel() {
    private val _teachers = MutableLiveData<List<Teacher>>()
    val teachers: LiveData<List<Teacher>> get() = _teachers

    fun fetchTeachers() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getTeachers()
                if (response.isSuccessful) {
                    _teachers.value = response.body()?.teachers
                } else {
                    // Handle the error case
                }
            } catch (e: Exception) {
                e.printStackTrace() // Log the error for debugging purposes
            }
        }
    }
}


