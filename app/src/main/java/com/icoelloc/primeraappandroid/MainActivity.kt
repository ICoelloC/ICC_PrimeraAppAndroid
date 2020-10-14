package com.icoelloc.primeraappandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.gms.actions.NoteIntents
import android.widget.Toast

/**
 * @author iCoelloC
 */

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
        // Según la opción seleccionada en el menú que seleccionemos:
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
        val intent = Intent(this, CrearContactoActivity::class.java)
        startActivity(intent)
    }
    //Enviamos un correo.
    private fun menuEnviarCorreo() {
        val intent = Intent(this, EnviarCorreoActivity::class.java)
        startActivity(intent)
    }
    //Creamos un evento
    private fun menuCrearEvento(){
        val intent = Intent(this, CrearEvento::class.java)
        startActivity(intent)
    }
    //Creamos una nota
    private fun menuCrearNota(){
        crearNota()
    }


    /**
     * Método que nos permite escribir una nota en nuestro telefono, si nuestro teléfono tiene esta funcionalidad,
     * lo hará si no la tiene, simplemente nos mostrará un toast con un mensaje que nos dirá que no tenemos ninguna
     * app externa que nos permita realizar esta función.
     *
     * Este es la página que me ha ayudado a implementar esta funcionalidad:
     *      https://emaildjt.wixsite.com/mindwhys/single-post/2018/02/01/Android--
     */
    private fun crearNota(){
        val titulo = "Lista de la compra"
        val cuerpo = "Pan, Agua, Leche, Fruta, bla bla bla"
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE)
            .putExtra(NoteIntents.EXTRA_NAME,titulo)
            .putExtra(NoteIntents.EXTRA_TEXT,cuerpo)
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this,"No hay aplicación disponible",Toast.LENGTH_SHORT).show()
        }
    }

}