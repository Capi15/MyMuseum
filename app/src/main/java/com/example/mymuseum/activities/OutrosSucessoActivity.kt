package com.example.mymuseum.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mymuseum.R

class OutrosSucessoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outros_sucesso)
        val currentLayout =
            findViewById<View>(R.id.outrosSucessoActivityId) as ConstraintLayout
        //define a cor do Layout
        currentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.catMusBack))
    }

    fun goBackToHome(view: View) {
        finish()
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("EXIT", true)
        startActivity(intent)
    }
}