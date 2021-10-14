package com.itsgg.academico.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionRest {
    private var retrofit: Retrofit? = null
    private const val RUTA_API = "http://75.119.155.19:22500"
    val connetion: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(RUTA_API)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
}