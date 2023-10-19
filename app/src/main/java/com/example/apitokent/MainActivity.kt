package com.example.apitokent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apitokent.Model.Api.Api
import com.example.apitokent.Model.Models.Students
import com.example.apitokent.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnGetall.setOnClickListener {
                GetAllStudents()
            }
            btnGetForId.setOnClickListener {
                GetStudentsId()
            }
            btnDeleteForId.setOnClickListener {
                DeleteStudentsId()
            }
            btnPost.setOnClickListener {
                PostStudents()
            }
        }
    }

    private fun PostStudents() {
        binding.txt.text = ""
        var NewStudent = Students(1, "Nohelis", "luna", "Null", "nohelis", "12345")
        Api.build.PostStudent(Api.token, NewStudent).enqueue(object : Callback<Students> {
            override fun onResponse(call: Call<Students>, response: Response<Students>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Ta lito", Toast.LENGTH_SHORT).show()
                    GetAllStudents()
                } else {
                    Toast.makeText(this@MainActivity, "Tamalito", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Students>, t: Throwable) {
                t.message?.let { Log.e("Error", it) }
            }
        })
    }

    private fun DeleteStudentsId() {
        binding.txt.text = ""
        var id = binding.etxt.text.toString()
        Api.build.DeleteStudent(Api.token, id).enqueue(object : Callback<Students> {
            override fun onResponse(call: Call<Students>, response: Response<Students>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Ta liminao", Toast.LENGTH_SHORT).show()
                    GetAllStudents()
                } else {
                    Toast.makeText(this@MainActivity, "Tamalo", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Students>, t: Throwable) {
                t.message?.let { Log.e("Error", it) }
            }
        })
    }

    private fun GetStudentsId() {
        binding.txt.text = ""
        var id = binding.etxt.text.toString()
        Api.build.GetForId(Api.token, id).enqueue(object : Callback<List<Students>> {
            override fun onResponse(
                call: Call<List<Students>>, response: Response<List<Students>>
            ) {
                var a = response.body()
                a?.forEach {
                    binding.txt.append(it.FirstName)
                }
            }

            override fun onFailure(call: Call<List<Students>>, t: Throwable) {
                t.message?.let { Log.e("Error", it) }
            }
        })
    }

    private fun GetAllStudents() {
        binding.txt.text = ""
        Api.build.GetAllStudents(Api.token).enqueue(object : retrofit2.Callback<List<Students>> {
            override fun onResponse(
                call: Call<List<Students>>, response: Response<List<Students>>
            ) {
                if (response.isSuccessful) {
                    var a = response.body()
                    a?.forEach {
                        binding.txt.append("${it.FirstName}  ${it.LastName}")
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Kgao", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<List<Students>>, t: Throwable) {
                t.message?.let { Log.e("Sapo", it) }
            }
        })
    }


}