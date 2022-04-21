package com.example.app_elecciones2022

fun convertirPorcentaje(cant: Int, total: Int): Double = ((cant.toDouble() / total.toDouble()) * 100)

fun stringFormatRed(num: Double): String = String.format("%.2f ", num)

