package com.example.mymuseum.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuseum.R
import com.example.mymuseum.adapters.CategoriaAdapter
import com.example.mymuseum.adapters.MuseuAdapter
import kotlinx.android.synthetic.main.activity_categoria.*
import kotlinx.android.synthetic.main.fragment_home.*


class CategoriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
        val currentLayout =
            findViewById<View>(R.id.categoriaLayoutId) as ConstraintLayout
        currentLayout.setBackgroundColor(Color.CYAN)
        //é criado um layout manager para este fragmento
        recylerViewCategoria.layoutManager = LinearLayoutManager(applicationContext)
        //depois é chamado o adaptador customizado
        recylerViewCategoria.adapter = CategoriaAdapter()
    }

    fun goToObra (view: View) {
        val intent = Intent(this, ObrasActivity::class.java)
        startActivity(intent)
    }
}
