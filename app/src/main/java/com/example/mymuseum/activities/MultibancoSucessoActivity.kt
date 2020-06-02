package com.example.mymuseum.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R
import com.example.mymuseum.ui.comprarbilhete.ComprarBilheteFragment
import com.example.mymuseum.ui.comprarbilhete.ComprarBilheteFragment.Companion.MyPREFERENCES

class MultibancoSucessoActivity : AppCompatActivity() {

    private lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multibanco_sucesso)
        val currentLayout =
            findViewById<View>(R.id.multibancoSucessoActivityId) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.catMusBack))
        button = findViewById(R.id.multibanco_sucesso_button)


        button.setOnClickListener{
            finish()
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("EXIT", true)
            startActivity(intent)
        }
    }

}