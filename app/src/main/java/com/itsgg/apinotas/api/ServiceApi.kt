package com.itsgg.academico.api

import com.itsgg.apinotas.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//interface ServiceApi {
//    @GET("/usuarios_ceduda/")
//    public fun listaUsuarios(@Query ("cedula") cedula: String): Call<List<User>>
//}


interface ServiceApi_Notas {
    @GET("/notas_x_materias/")
    public fun listaCalificaciones(@Query ("cedula") cedula: String): Call<List<notas_materias>>
}