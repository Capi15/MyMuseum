package com.example.mymuseum.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuseum.R
import kotlinx.android.synthetic.main.museu_row.view.*

class MuseuAdapter : RecyclerView.Adapter<CustomViewHolder>(){

    //imagem default
    val intImage = R.drawable.icon_perfil

    //array de imagens 2
    val stringTitulo = arrayOf("Franca", "Portugal", "Espanha", "China", "Alemanhã")
    val stringDescricao = arrayOf("O melhor museu Europeu", "Museus do minho", "Venha Visitarnos", "Melhor museu Asiatico", "Segundo melhor museu Europeu")

    // associa um layout personalizado a cada linha(celula) do adaptador
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.museu_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    //o tamanho deste adaptador é igual ao tamanho de imagens em qualquer um dos arrays
    override fun getItemCount(): Int {
        return stringTitulo.size
    }

    //pupola cada celula costumizada com elementos de cada um dos arrays
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //a cada posicao vai ser inserida uma imagem
        val image = intImage
        val titulo = stringTitulo.get(position)
        val descricao = stringDescricao.get(position)
        //é associada a imagem do array ao seu recurso, neste caso uma imageView
        holder?.view?.museu_image?.setImageResource(image)
        holder?.view?.museu_titulo.setText(titulo)
        holder?.view?.museu_descricao.setText(descricao)
    }
}

// permite receber uma view, neste caso uma ImageView
class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){

}