package com.example.mymuseum.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R
import com.example.mymuseum.ui.comprarbilhete.ComprarBilheteFragment.Companion.MyPREFERENCES

class PagamentoOnline_3_2_Activity : AppCompatActivity() {

    private lateinit var nomeCart: EditText
    private lateinit var numeroCart: EditText
    private lateinit var validade: EditText
    private lateinit var cvv: EditText
    private lateinit var textValor: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_online_3_2_)
        val currentLayout =
            findViewById<View>(R.id.pagamentoOnline_3_2_ActivityId) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.newBackground))
        nomeCart = findViewById(R.id.pagamento_online_outros_nomecartao_edit)
        numeroCart = findViewById(R.id.pagamento_online_outros_ncartao_edit)
        validade = findViewById(R.id.pagamento_online_outros_validade_edit)
        cvv = findViewById(R.id.pagamento_online_outros_cvv_edit)
        textValor = findViewById(R.id.pagamento_online_outros_valor)

        val preferences =
            getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val valor = preferences.getString("VALOR", "")
        textValor.text = valor

    }

    fun concluiPagamento(view: View) {
        val intent: Intent
        if(nomeCart.text.isEmpty() || numeroCart.text.isEmpty() || validade.text.isEmpty() || cvv.text.isEmpty()){
            Toast.makeText(this, "Todos os campos devem estar preenchidos", Toast.LENGTH_SHORT).show()
        }else{
            intent = Intent(this, OutrosSucessoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
