package com.example.mymuseum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R

class PagamentoOnline_1_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_online_1)
        val currentLayout =
            findViewById<View>(R.id.pagamentoOnline_1Id) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.newBackground))
    }

    fun goToStep2(view: View) {
        val intent = Intent(this, PagamentoOnline_2_Activity::class.java)
        startActivity(intent)
    }
}
