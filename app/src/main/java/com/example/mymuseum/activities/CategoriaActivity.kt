package com.example.mymuseum.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuseum.R
import com.example.mymuseum.adapters.CategoriaAdapter
import kotlinx.android.synthetic.main.activity_categoria.*


class CategoriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
        val currentLayout =
            findViewById<View>(R.id.categoriaLayoutId) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.catMusBack))
        //é criado um layout manager para este fragmento
        recylerViewCategoria.layoutManager = LinearLayoutManager(applicationContext)
        //depois é chamado o adaptador customizado
        recylerViewCategoria.adapter = CategoriaAdapter()
    }

    //permite iniciar a atividade das obras
    fun goToObra (view: View) {
        val intent = Intent(this, ObrasActivity::class.java)
        startActivity(intent)
    }
}
