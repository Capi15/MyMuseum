package com.example.mymuseum.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuseum.R
import kotlinx.android.synthetic.main.museu_row.view.*
import kotlinx.android.synthetic.main.row_obra.view.*

class ObraAdapter : RecyclerView.Adapter<CustomViewHolder>(){

    //imagem default
    val intArray = intArrayOf(
        R.drawable.ac,
        R.drawable.at,
        R.drawable.cora,
        R.drawable.mona
    )

    //array de imagens 2
    val stringTitulo = arrayOf(
        "Colagens Abstratas",
        "Rui Sanches",
        "Coração de Viana",
        "Monalisa")

    val stringDescricao = arrayOf("observe as noças perças mais antigas",
        "Varios tipos de Colagens crião novas formas",
        "Pintura com tinta da china",
        "O seu coração vale ouro",
        "O quadro que o Observa")

    // associa um layout personalizado a cada linha(celula) do adaptador
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_obra, parent, false)
        return CustomViewHolder(cellForRow)
    }

    //o tamanho deste adaptador é igual ao tamanho de imagens em qualquer um dos arrays
    override fun getItemCount(): Int {
        return stringTitulo.size
    }

    //pupola cada celula costumizada com elementos de cada um dos arrays
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //a cada posicao vai ser inserida uma imagem
        val image = intArray.get(position)
        val titulo = stringTitulo.get(position)
        val descricao = stringDescricao.get(position)
        //é associada a imagem do array ao seu recurso, neste caso uma imageView
        holder?.view?.obra_image?.setImageResource(image)
        holder?.view?.obra_titulo.setText(titulo)
        holder?.view?.obra_descricao.setText(descricao)
    }
}