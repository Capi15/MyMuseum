package com.example.mymuseum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R

class PagamentoOnline_2_Activity : AppCompatActivity() {

    var radioGroupPagamento: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_online_2_)
        radioGroupPagamento = findViewById(R.id.pagamento_online_tipo_grupo)
        val currentLayout =
            findViewById<View>(R.id.pagamentoOnline_2Id) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.catMusBack))
    }

    fun goToStep3(view: View) {
        when (R.id.pagamento_online_tipo_grupo) {
            R.id.pagamento_online_tipo_radiobutton_1 -> {
                val intent = Intent(this, PagamentoOnline_3_1_Activity::class.java)
                startActivity(intent)
            }
            R.id.pagamento_online_tipo_radiobutton_2 -> {
                val intent = Intent(this, PagamentoOnline_3_2_Activity::class.java)
                startActivity(intent)
            }
        }
    }

    fun checkButton_pagamento(view: View) {

        val radioId = radioGroupPagamento?.checkedRadioButtonId
        radioGroupPagamento = findViewById(radioId!!)
    }
}
