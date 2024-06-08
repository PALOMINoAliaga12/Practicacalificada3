package com.palomino.luis.laboratoriocalificado3.network

import retrofit2.http.GET
import com.palomino.luis.laboratoriocalificado3.model.TeacherResponse
import retrofit2.Response

interface ApiService {
    @GET("list/teacher")
    suspend fun getTeachers(): Response<TeacherResponse>
}
