package com.icoelloc.primeraappandroid

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_crear_contacto.*

class CrearContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_contacto)

        contactos_agregar.setOnClickListener { crearContacto() }
    }

    /**
     * Método que inicia la aplicación de Contactos para crear directamente un contacto, extrayendo los
     * valores que hay en cada campo de texto.
     *
     * Link al api de Android--> https://developer.android.com/guide/components/intents-common?hl=es#InsertContact
     */
    private fun crearContacto() {

        val nombreContacto = contactos_txtNombre.text.toString()
        val correoContacto = contactosCorreo.text.toString()

        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, nombreContacto)
            putExtra(ContactsContract.Intents.Insert.EMAIL, correoContacto)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }



}