package com.example.mymuseum.adapters

import android.content.Context
import android.os.Message
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuseum.R
import com.example.mymuseum.activities.MainActivity
import com.example.mymuseum.classes.MyMessage
import kotlinx.android.synthetic.main.row_mensagens.view.*
import java.util.ArrayList
import kotlin.reflect.KMutableProperty1

class MensagensAdapter (
    var arrayMensagens: List<MyMessage>,
    var context : Context
) : RecyclerView.Adapter<CustomViewHolder>() {

    // associa um layout personalizado a cada linha(celula) do adaptador
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_mensagens, parent, false)
        return CustomViewHolder(cellForRow)
    }

    //o tamanho deste adaptador é igual ao tamanho de imagens em qualquer um dos arrays
    override fun getItemCount(): Int {
        return arrayMensagens.size
    }

    //pupola cada celula costumizada com elementos de cada um dos arrays
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val myMessage: MyMessage = arrayMensagens.get(position)

        //é associada a imagem do array ao seu recurso, neste caso uma imageView
        holder.view.mensagem_mensagens.setText(myMessage.message)

        if(myMessage.saoMinhas){
            holder.view.mensagem_mensagens.gravity = Gravity.BOTTOM or Gravity.END
            holder.view.mensagem_mensagens.setTextColor(context.getColor(R.color.minhaMensagem))
        } else {
            holder.view.mensagem_mensagens.gravity = Gravity.BOTTOM or Gravity.START
            holder.view.mensagem_mensagens.setTextColor(context.getColor(R.color.outraMensagem))
        }
    }

    fun setData(dados : List<MyMessage>){
        arrayMensagens = dados
    }


}



