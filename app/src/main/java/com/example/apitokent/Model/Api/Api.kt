package com.example.apitokent.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api {
    var token =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjEiLCJuYmYiOjE2OTc3MjU0OTAsImV4cCI6NzY5NzcyNTQzMCwiaWF0IjoxNjk3NzI1NDkwLCJpc3MiOiIzMjI4MzExMC04M2YwLTQ4OWUtYmU0MC04ZTAwZDYyOTk1OGYiLCJhdWQiOiJTb2Z0d2FyZSBGb25TRU5BLUpEIn0.2K5j5FwAPRtLeuLP83lcEKqiHURz9Q_L66WSzQm_Vqg"
    private var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.9.107:8888/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var build = retrofit.create(ApiService::class.java)
}