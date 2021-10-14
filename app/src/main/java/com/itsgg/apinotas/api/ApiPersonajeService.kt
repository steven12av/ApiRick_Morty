package com.itsgg.apinotas.api

import com.itsgg.apinotas.model.ResultPersonaje
import retrofit2.Call
import retrofit2.http.GET

interface ApiPersonajeService {

    @GET ("character")

    fun obtenerPersonaje():Call<ResultPersonaje>

}