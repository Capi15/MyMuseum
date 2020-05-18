package com.example.mymuseum.activities

import GetDataService
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mymuseum.R
import com.example.mymuseum.retrofit.RetrofitClientInstance
import com.example.mymuseum.retrofit.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.String.valueOf
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    var btn_login: Button? = null
    var et_email: EditText? = null
    var et_password:EditText? = null
    var progressBar: ProgressBar? = null
    val MyPREFERENCES = "MyPrefs"
    val ID = "userId"
    val TOKEN = "api_token"
    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.button_login_login)
        et_email = findViewById<EditText>(R.id.editText_login_nome)
        et_password = findViewById<EditText>(R.id.editText_login_pass)
        progressBar = findViewById(R.id.progressBar_login)
        sharedpreferences =
            getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
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


    fun login(view: View) {
        //Cria uma instancia da interface do retrofit
        btn_login?.setVisibility(View.GONE);
        progressBar?.setVisibility(View.VISIBLE);
        val service = RetrofitClientInstance.retrofitInstance?.create(GetDataService::class.java)
        val newUser = User(et_email!!.text.toString(), et_password!!.text.toString())
        val call = service!!.login(newUser)
        call!!.enqueue(object: Callback<User?>{

            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                if(response.body() != null){
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    val editor = sharedpreferences!!.edit()

                    response.body()!!.id?.let { editor.putLong("ID", it) }
                    response.body()!!.api_token?.let { editor.putString("TOKEN", it) }
                    editor.commit()
                    Toast.makeText(applicationContext, valueOf(sharedpreferences!!.getString("ID", "")),Toast.LENGTH_LONG).show()
                    Toast.makeText(applicationContext, valueOf(sharedpreferences!!.getString("TOKEN", "")),Toast.LENGTH_LONG).show()
                    //Toast.makeText(applicationContext, "Bem Vindo", Toast.LENGTH_LONG).show()
                    finish();
                }
            }
            override fun onFailure(call: Call<User?>, t: Throwable) {
                Toast.makeText(applicationContext, "Dados não retornados", Toast.LENGTH_LONG).show()
                btn_login?.setVisibility(View.VISIBLE);
                progressBar?.setVisibility(View.GONE);
            }

        })
    }

}
