package com.example.mymuseum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R

class PagamentoOnline_1_Activity : AppCompatActivity() {

    private lateinit var nome: EditText
    private lateinit var email: EditText
    private lateinit var telemovel: EditText
    private lateinit var morada: EditText
    private lateinit var codigoPostal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_online_1)
        val currentLayout =
            findViewById<View>(R.id.pagamentoOnline_1Id) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.newBackground))
        nome = findViewById(R.id.pagamento_online_fat_nome_text)
        email = findViewById(R.id.pagamento_online_fat_email_text)
        telemovel = findViewById(R.id.pagamento_online_fat_telemovel_text)
        morada = findViewById(R.id.pagamento_online_fat_morada_text)
        codigoPostal = findViewById(R.id.pagamento_online_fat_codigo_postal_text)

    }

    fun goToStep2(view: View) {
        if(nome.text.isEmpty() || email.text.isEmpty() || telemovel.text.isEmpty() || morada.text.isEmpty() || codigoPostal.text.isEmpty()){
            Toast.makeText(this, "Por favor preencha todos os campos", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, PagamentoOnline_2_Activity::class.java)
            startActivity(intent)
        }

    }
}
