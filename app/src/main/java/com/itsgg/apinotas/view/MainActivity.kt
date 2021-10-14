package com.itsgg.apinotas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.itsgg.apinotas.R
import com.itsgg.apinotas.adapter.PersonajeAdapter
import com.itsgg.apinotas.api.ApiPersonajeService
import com.itsgg.apinotas.databinding.ActivityMainBinding
import com.itsgg.apinotas.model.Personaje
import com.itsgg.apinotas.model.ResultPersonaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiservice: ApiPersonajeService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        binding.rvpersonaje.layoutManager = LinearLayoutManager(this)

        apiservice= retrofit.create<ApiPersonajeService>(ApiPersonajeService::class.java)
        obtenerPersonajes()


    }

    private fun obtenerPersonajes() {
        apiservice.obtenerPersonaje().enqueue(
            object :Callback<ResultPersonaje>{
                override fun onResponse(
                    call: Call<ResultPersonaje>,
                    response: Response<ResultPersonaje>
                ) {
                    val listapersonaje = response.body()!!.results
                    binding.rvpersonaje.adapter= PersonajeAdapter(listapersonaje)
                }

                override fun onFailure(call: Call<ResultPersonaje>, t: Throwable) {

                }

            }
        )
    }

}