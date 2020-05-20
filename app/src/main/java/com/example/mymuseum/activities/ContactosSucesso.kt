package com.example.mymuseum.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mymuseum.R

class ContactosSucesso : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos_sucesso)
    }

    fun goBackToContactos(view: View) {
        finish()
    }
}
