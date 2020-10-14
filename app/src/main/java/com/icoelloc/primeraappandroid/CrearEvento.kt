package com.icoelloc.primeraappandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import kotlinx.android.synthetic.main.activity_crear_evento.*

class CrearEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_evento)

        crearEvento_btnCrearEvento.setOnClickListener { crearEvento() }

    }

    /**
     * Método que inicia la aplicación de Google Calendar para crear directamente un evento
     *
     * Link al api de Android--> https://developer.android.com/guide/components/intents-common?hl=es#AddEvent
     */
    fun crearEvento() {

        val tituloEvento = crearEvento_txtNombreEvento.text.toString()
        val localizacion = crearEvento_txtLocalizacion.text.toString()

        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, tituloEvento)
            putExtra(CalendarContract.Events.EVENT_LOCATION, localizacion)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


}