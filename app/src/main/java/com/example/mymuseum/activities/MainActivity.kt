package com.example.mymuseum.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.Gravity
import android.view.Gravity.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mymuseum.R
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    var radioGroupMuseu: RadioGroup? = null
    var radioGroupBilhete: RadioGroup? = null
    var myText: TextView? = null
    private var myEditText: EditText? = null
    var button : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        radioGroupMuseu = findViewById(R.id.compraB_grupo_museus)
        radioGroupBilhete = findViewById(R.id.compraB_grupo_bilhetes)


        Log.i("log", button.toString())



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_perfil,
            R.id.nav_home,
            R.id.nav_contactos,
            R.id.nav_comprar_bilhete,
            R.id.nav_mensagens,
            R.id.nav_terminar_sessao
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun enviaMensagem(view: View) {
        val random: Int = (0 .. 3).random()
        myEditText = findViewById(R.id.mensagem_campo_envio)
        myText = findViewById(R.id.mensagem_mensagens)
        if(myEditText?.text.toString() ==  ""){
            return
        }
        val append = (myEditText?.text).toString() + "\n\n"
        myText?.setTextColor(Color.GREEN)
        myText?.append(append)
        myText?.append(respostaMensagem.get(random) + "\n\n")
        myEditText?.setText("")
    }

    fun add_obras(view: View) {
        myEditText = findViewById(R.id.mensagem_campo_envio)
        myText = findViewById(R.id.mensagem_mensagens)

    }


    val respostaMensagem = arrayOf(
        "nice!",
        "gostei muito!",
        "manda mais!",
        "sapnu puas")

    fun checkButton_museu (view: View) {
        val radioId = radioGroupMuseu?.checkedRadioButtonId
        radioGroupMuseu = radioId?.let { findViewById(it) }
    }

    fun checkButton_bilhete (view: View) {
        val radioId = radioGroupBilhete?.checkedRadioButtonId
        radioGroupBilhete = radioId?.let { findViewById(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sair->{
                //permite sair da aplicação
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    fun goToCategoriaFromCard(view: View) {
        val intent = Intent(this, CategoriaActivity::class.java)
        startActivity(intent)
    }

    fun goToAllPrecos(view: View) {
        val intent = Intent(this, PrecosBilheteActivity::class.java)
        startActivity(intent)
    }

    fun LimpaDados(view: View) {

    }

    fun goToTipoPagamento(view: View) {
        val intent = Intent(this, TipoPagamentoActivity::class.java)
        startActivity(intent)
        finish()
    }




}