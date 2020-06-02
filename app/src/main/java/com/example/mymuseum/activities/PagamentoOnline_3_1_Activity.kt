package com.example.mymuseum.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R
import com.example.mymuseum.ui.comprarbilhete.ComprarBilheteFragment

class PagamentoOnline_3_1_Activity : AppCompatActivity() {

    private lateinit var textValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_online_3_1_)
        val currentLayout =
            findViewById<View>(R.id.pagamentoOnline_3_1_ActivityId) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.newBackground))
        textValor = findViewById(R.id.pagamento_online_multibanco_valor)

        val preferences =
            getSharedPreferences(ComprarBilheteFragment.MyPREFERENCES, Context.MODE_PRIVATE)
        val valor = preferences.getString("VALOR", "")
        textValor.text = valor
    }

    fun concluiPagamento(view: View) {
        val intent = Intent(applicationContext, MultibancoSucessoActivity::class.java)
        startActivity(intent)
        finish()
    }
}
