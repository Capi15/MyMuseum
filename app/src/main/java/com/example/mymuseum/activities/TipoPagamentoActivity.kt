package com.example.mymuseum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R

class TipoPagamentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_pagamento)
        val currentLayout =
            findViewById<View>(R.id.tipoPagamentoId) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.catMusBack))
    }

    fun goToOnlinePayment(view: View) {
        val intent = Intent(this, PagamentoOnline_1_Activity::class.java)
        startActivity(intent)
    }
    fun gotoToFisicoPayment(view: View) {
        val intent = Intent(this, PagamentoFisicoActivity::class.java)
        startActivity(intent)
        finish()
    }
}
