package com.example.mymuseum.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mymuseum.R
import com.example.mymuseum.classes.MyMessage
import com.google.android.material.navigation.NavigationView
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    var radioGroupMuseu: RadioGroup? = null
    var radioGroupBilhete: RadioGroup? = null
    var myText: TextView? = null
    private var myEditText: EditText? = null
    var button : Button? = null



    companion object{
        var mensages: MutableList<MyMessage> = ArrayList()
        val respostaMensagem = arrayOf(
            "nice!",
            "gostei muito!",
            "manda mais!",
            "sapnu puas")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        //permite aceder a cada radioGroup
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



    //adiciona obras às mensagens
    fun add_obras(view: View) {
        myEditText = findViewById(R.id.mensagem_campo_envio)
        myText = findViewById(R.id.mensagem_mensagens)

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

    //permite usar o menu de items, neste caso é usado para sair da aplicação
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sair->{
                //permite sair da aplicação
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    //entra na atividade das categorias através dos cards dos museus
    fun goToCategoriaFromCard(view: View) {
        val intent = Intent(this, CategoriaActivity::class.java)
        startActivity(intent)
    }

    //entra na atividade dos preços dos museus
    fun goToAllPrecos(view: View) {
        val intent = Intent(this, PrecosBilheteActivity::class.java)
        startActivity(intent)
    }




}