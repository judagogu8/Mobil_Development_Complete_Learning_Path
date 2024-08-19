package com.example.taller_1.utils

import android.content.Context
import android.util.Log
import com.example.taller_1.models.CountryResponse
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import java.io.IOException

object JsonParser {

    private const val TAG = "JsonParser"

    // .? es un operador de llamada segura que devuelve null si el objeto es nulo,
    // ya que Kotlin no permite acceder a propiedades de objetos nulos.

    // Función para parsear el JSON de los países:
    fun parseCountries(context: Context, fileName: String): CountryResponse? {

        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            Log.e(TAG, "Error reading JSON file: ${e.message}")
            return null
        }

        return try {
            val countryResponseType = object : TypeToken<CountryResponse>() {}.type
            Gson().fromJson(jsonString, countryResponseType)
        } catch (e: JsonSyntaxException) {
            Log.e(TAG, "Error parsing JSON: ${e.message}")
            null
        }
    }
}