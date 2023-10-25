package com.example.apitokent.Model.Api

import com.example.apitokent.Model.Models.Instructors
import com.example.apitokent.Model.Models.Students
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("Student")
    fun GetAllStudents(@Header("authorization") token: String): Call<List<Students>>


    @GET("Student/{id}")
    fun GetForId(
        @Header("authorization") tokent: String, @Path("id") id: String
    ): Call<Students>

    @POST("Student")
    fun PostStudent(@Header("authorization") tokent: String, @Body kkk: Students): Call<Students>

    @DELETE("Student/{id}")
    fun DeleteStudent(
        @Header("authorization") tokent: String, @Path("id") id: String
    ): Call<Students>


    @GET("Instructor")
    fun GetAllIstructor(@Header("authorization") tokent: String): Call<List<Instructors>>

    @GET("Instructor/{id}")
    fun GetIstructorForId(
        @Header("authorization") tokent: String, @Path("id") id: String
    ): Call<Instructors>


    @POST("Instructor")
    fun PostInstructor(
        @Header("authorization") tokent: String,
        @Body instructor: Instructors
    ): Call<Instructors>

    @DELETE("Instructor/{id}")
    fun DeleteInstructor(
        @Header("authorization") tokent: String, @Path("id") id: String
    ): Call<Instructors>


}