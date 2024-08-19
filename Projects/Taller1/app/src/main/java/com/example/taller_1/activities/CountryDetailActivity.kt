package com.example.taller_1.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller_1.R
import com.example.taller_1.databinding.ActivityCountryDetailBinding
import com.squareup.picasso.Picasso

class CountryDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Actualizamos la imagen de la bandera del país (usando Picasso):
        Picasso.get().load(intent.getStringExtra("flag")).into(binding.ivCountryFlag)
        
        // Actualizamos el nombre del país:
        binding.tvCountryName.text = "Nombre: " + intent.getStringExtra("name")

        // Actualizamos el Alpha3Code del país:
        binding.tvCountryAlpha3Code.text = "Alpha3Code: " + intent.getStringExtra("alpha3Code")

        // Actualizamos la región  del país:
        binding.tvCountryRegion.text = "Región: " + intent.getStringExtra("region")

        // Actualizamos la subregión del país:
        binding.tvCountrySubregion.text = "Subregión: " + intent.getStringExtra("subRegion")

        // Actualizamos el área del país:
        binding.tvCountryArea.text = "Área: " + intent.getStringExtra("area") + " km²"

        // Actualizamos la latitud del país:
        binding.tvCountryLatitude.text = "Latitud: " + intent.getStringExtra("latitude")

        // Actualizamos la longitud del país:
        binding.tvCountryLongitude.text = "Longitud: " + intent.getStringExtra("longitude")

        // Actualizamos la moneda del país:
        binding.tvCountryCurrency.text = "Moneda: " + intent.getStringExtra("currencyCode") + " (" + intent.getStringExtra("currencySymbol") + ")"

        // Agregamos funcionalidad al botón de llamadas:
        binding.fbCalls.setOnClickListener {

            // Abre la aplicación de llamadas con el número de teléfono del país:
            val numberCode = intent.getStringExtra("numericCode")?.toIntOrNull() ?: 0
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numberCode")
            startActivity(intent)
        }
    }
}