package com.example.apitokent.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api {
    var token =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjEiLCJuYmYiOjE2OTc2ODg5MjksImV4cCI6NzY5NzY4ODg2OSwiaWF0IjoxNjk3Njg4OTI5LCJpc3MiOiIzMjI4MzExMC04M2YwLTQ4OWUtYmU0MC04ZTAwZDYyOTk1OGYiLCJhdWQiOiJTb2Z0d2FyZSBGb25TRU5BLUpEIn0.TGjlqSM8wSrVaq5MCJw6EWMSkGNgZLz1KF2dszSq9os"
    private var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.101.9:8888/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var build = retrofit.create(ApiService::class.java)
}