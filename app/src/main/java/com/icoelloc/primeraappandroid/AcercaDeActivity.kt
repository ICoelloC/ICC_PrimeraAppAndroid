package com.icoelloc.primeraappandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_acerca_de.*

class AcercaDeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)
        acerca_de_BotonTwitter.setOnClickListener { entrarURL("https://twitter.com/ICoelloC") }
        acerca_de_BotonGithub.setOnClickListener { entrarURL("https://github.com/ICoelloC") }
    }

    private fun entrarURL(url: String) {
        val intent = Intent(Intent.ACTION_VIEW,  Uri.parse(url))
        startActivity(intent)
    }
}