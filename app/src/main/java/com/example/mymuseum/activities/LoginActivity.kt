package com.example.mymuseum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.mymuseum.R
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.login_menu, menu)
        return true
    }

    //funcões do menu de opções quando são clicadas
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_login_sair->{
                //permite sair da aplicação
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun goToRegister(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

}
