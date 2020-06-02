package com.example.mymuseum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R

class PagamentoOnline_2_Activity : AppCompatActivity() {

    private lateinit var radioGroupPagamento: RadioGroup
    private lateinit var radioGroup: RadioGroup
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    var escolhe = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_online_2_)

        val currentLayout =
            findViewById<View>(R.id.pagamentoOnline_2Id) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.newBackground))
        radioGroupPagamento = findViewById(R.id.pagamento_online_tipo_grupo)
        radio1 = findViewById(R.id.pagamento_online_tipo_radiobutton_1)
        radio2 = findViewById(R.id.pagamento_online_tipo_radiobutton_2)

        radioGroupPagamento.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                radio1.id -> {
                    escolhe = true
                }
                radio2.id -> {
                    escolhe = false
                }
            }
        }
    }

    fun goToStep3(view: View) {
        var intent: Intent = if(escolhe){
            Intent(this, PagamentoOnline_3_1_Activity::class.java)
        }else{
            Intent(this, PagamentoOnline_3_2_Activity::class.java)
        }
        startActivity(intent)

    }
}
