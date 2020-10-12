package com.icoelloc.primeraappandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Creación del menú
    // https://developer.android.com/guide/topics/ui/menus?hl=es#kotlin
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Opciones a pulsar un estado del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Según la opción seleccionada en el menú:
        return when (item.itemId) {
            R.id.menu_acerca_de -> {
                menuAcercaDe()
                true
            }
            R.id.menu_contactos -> {
                menuContactos()
                true
            }
            R.id.menu_correos -> {
                menuEnviarCorreo()
                true
            }
            R.id.menu_eventos_calendario -> {
                menuCrearEvento()
                true
            }
            R.id.menu_notas -> {
                menuCrearNota()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Accedemos a la Activity de Acerca de
    private fun menuAcercaDe() {
        val intent = Intent(this, AcercaDeActivity::class.java)
        startActivity(intent)
    }
    //Creamos un contacto.
    private fun menuContactos(){
        crearContacto()
    }
    //Enviamos un correo.
    private fun menuEnviarCorreo() {
        mandarCorreo("alumnoIvanCoello@alumno.com", "Práctica", "Espero aprobar esta práctica")
    }
    //Creamos un evento
    private fun menuCrearEvento(){
        crearEvento()
    }
    //Creamos una nota
    private fun menuCrearNota(){
        crearNota()
    }

    /**
     * Método que inicia la aplicación de Contactos para crear directamente un contacto.
     *
     * Link al api de Android--> https://developer.android.com/guide/components/intents-common?hl=es#InsertContact
     */
    fun crearContacto() {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    /**
     * Método para enviar un correo, en este caso
     * @param receptor --> este sería el correo de la persona a la que le queremos envía un correo.
     * @param asunto --> este es el asunto del correo.
     * @param mensaje --> este sería el mensaje que querríamos envíar al receptor.
     *
     * Link al api de Android--> https://developer.android.com/guide/components/intents-common?hl=es#Email
     */
    private fun mandarCorreo(receptor: String, asunto: String, mensaje: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receptor))
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
        intent.putExtra(Intent.EXTRA_TEXT, mensaje)
        try {
            startActivity(Intent.createChooser(intent, "Enviar usando..."))
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Método que inicia la aplicación de Google Calendar para crear directamente un evento
     *
     * Link al api de Android--> https://developer.android.com/guide/components/intents-common?hl=es#AddEvent
     */
    fun crearEvento() {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun crearNota() {

    }

}