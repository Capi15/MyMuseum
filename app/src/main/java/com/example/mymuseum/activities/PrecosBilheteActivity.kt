package com.example.mymuseum.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuseum.R
import com.example.mymuseum.adapters.CategoriaAdapter
import com.example.mymuseum.adapters.PrecoBilheteAdapter
import kotlinx.android.synthetic.main.activity_categoria.*
import kotlinx.android.synthetic.main.activity_obras.*
import kotlinx.android.synthetic.main.activity_precos_bilhete.*

class PrecosBilheteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precos_bilhete)
        val currentLayout =
            findViewById<View>(R.id.precosBilheteLayoutId) as ConstraintLayout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.catMusBack))
        //é criado um layout manager para este fragmento
        recyclerViewPrecosBilhete.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false )
        //depois é chamado o adaptador customizado
        recyclerViewPrecosBilhete.adapter = PrecoBilheteAdapter()
    }
}
