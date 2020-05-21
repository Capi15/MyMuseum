package com.example.mymuseum.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuseum.R
import com.example.mymuseum.adapters.ObraAdapter
import kotlinx.android.synthetic.main.activity_obras.*

class ObrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obras)
        val currentLayout =
            findViewById<View>(R.id.obraLayoutId) as ConstraintLayout
        currentLayout.setBackgroundColor(Color.CYAN)
        //é criado um layout manager para este fragmento
        recyclerViewObra.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false )
        //depois é chamado o adaptador customizado
        recyclerViewObra.adapter = ObraAdapter()
    }
}
