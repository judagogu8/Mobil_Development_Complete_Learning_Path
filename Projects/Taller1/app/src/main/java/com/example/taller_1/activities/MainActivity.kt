package com.example.taller_1.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller_1.R
import com.example.taller_1.databinding.ActivityMainBinding
import com.example.taller_1.utils.JsonParser

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargamos la lista de países:
        val countriesData = JsonParser.parseCountries(this, "data.json")
        val countriesList = countriesData?.Countries
        val countriesLength = countriesData?.TotalCount
        val Alpha3Code = countriesList?.get(3)?.Alpha3Code.toString()

        // Mapeamos para obtener solo el nombre y el nombre nativo de los países:
        val countriesMap = countriesData?.Countries?.map { country ->
            "${country.Name} (${country.NativeName})"
        }

        // Utilizamos un array adapter para mostrar los países:
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countriesMap ?: emptyList())
        binding.lvCountries.adapter = adapter

        // Al clickear cambiamos a la vista de detalle del país:
        binding.lvCountries.setOnItemClickListener { parent, view, position, id ->

            // Obtenemos el país seleccionado:
            val country = countriesList?.get(position)

            // Obtenemos los atributos de interés que queremos mostrar en la vista de detalle del país:
            val alpha3Code = country?.Alpha3Code
            val name = country?.Name
            val area = country?.Area.toString()
            val currencyCode = country?.CurrencyCode
            val currencySymbol = country?.CurrencySymbol
            val longitude = country?.Longitude
            val latitude = country?.Latitude
            val flag = country?.FlagPng
            val region = country?.Region
            val subRegion = country?.SubRegion
            val numericCode = country?.NumericCode.toString()

            // Creamos un intent para abrir la vista de detalle del país:
            val intent = Intent(this, CountryDetailActivity::class.java)

            // Pasamos los atributos de interés a la vista de detalle del país:
            intent.putExtra("alpha3Code", alpha3Code)
            intent.putExtra("name", name)
            intent.putExtra("area", area)
            intent.putExtra("currencyCode", currencyCode)
            intent.putExtra("currencySymbol", currencySymbol)
            intent.putExtra("longitude", longitude)
            intent.putExtra("latitude", latitude)
            intent.putExtra("flag", flag)
            intent.putExtra("region", region)
            intent.putExtra("subRegion", subRegion)
            intent.putExtra("numericCode", numericCode)

            // Iniciamos la vista de detalle del país:
            startActivity(intent)
        }
    }
}