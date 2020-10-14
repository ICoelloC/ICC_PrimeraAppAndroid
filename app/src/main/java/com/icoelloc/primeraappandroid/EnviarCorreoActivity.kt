package com.icoelloc.primeraappandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enviar_correo.*

/**
 * @author iCoelloC
 */
class EnviarCorreoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_correo)

        correo_btnEnviar.setOnClickListener { mandarCorreo() }

    }

    /**
     * Método para enviar un correo, en este caso recoge los valores de las cajas de texto, y usandolos para los
     * distintos campos del correo
     *
     * Link al api de Android--> https://developer.android.com/guide/components/intents-common?hl=es#Email
     */
    private fun mandarCorreo() {

        val destinatario = editTextTextEmailAddress.text.toString()
        val asunto = correo_txtAsunto.text.toString()
        val mensaje = correo_txtMensaje.text.toString()

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, destinatario)
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, mensaje)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}