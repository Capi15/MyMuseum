package com.example.mymuseum.ui.mensagens

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuseum.R
import com.example.mymuseum.activities.MainActivity
import com.example.mymuseum.adapters.MensagensAdapter
import com.example.mymuseum.adapters.MuseuAdapter
import com.example.mymuseum.classes.MyMessage
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_precos_bilhete.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_mensagens.view.*
import java.util.*
import kotlin.concurrent.schedule

class MensagensFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_mensagens, container, false)
        root.setBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.catMusBack))
        //é criado um layout manager para este fragmento
        root.mensagens_recycler.layoutManager = LinearLayoutManager(activity)
        //depois é chamado o adaptador customizado
        root.mensagens_recycler.adapter = MensagensAdapter(MainActivity.mensages, requireContext())
        root.mensagem_button_enviar.setOnClickListener{
            enviaMensagem(it)
        }
        return root
    }

    companion object{
        var responseTimer: Timer = Timer("responseTimer", false)
    }

    //responsável por enviar as mensagens
    fun enviaMensagem(view: View) {
        try {
            responseTimer.cancel()
            responseTimer = Timer("responseTimer", false)
        } catch (t : Throwable){

        }

        val recyclerView = activity?.findViewById<RecyclerView>(R.id.mensagens_recycler)!!
        val myText: String = activity?.findViewById<EditText>(R.id.mensagem_campo_envio)?.text.toString().trim()
        val myMessage: MyMessage = MyMessage(true, myText)
        if(myText.isEmpty()){
            Snackbar.make(requireActivity().findViewById(R.id.drawer_layout), "A sua mensagem está vazia", Snackbar.LENGTH_SHORT).show()
            return
        }
        MainActivity.mensages.add(myMessage)
        (recyclerView.adapter as MensagensAdapter).setData(MainActivity.mensages)
        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.scrollToPosition(MainActivity.mensages.size -1)

        responseTimer.schedule(2000){
            val response: MyMessage = MyMessage(false, MainActivity.respostaMensagem.random())
            MainActivity.mensages.add(response)
            activity?.runOnUiThread{
                (recyclerView.adapter as MensagensAdapter).setData(MainActivity.mensages)
                recyclerView.adapter?.notifyDataSetChanged()
                recyclerView.scrollToPosition(MainActivity.mensages.size -1)
            }
        }
    }
}
