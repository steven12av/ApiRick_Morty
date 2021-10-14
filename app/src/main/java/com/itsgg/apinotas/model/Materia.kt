package com.itsgg.apinotas.model

data class Materia(
    val notas: List<Nota>,
    val v_cedula: String,
    val v_materia: String
)