package com.example.mymuseum.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuseum.R
import kotlinx.android.synthetic.main.row_bilhetes_museu_preco.view.*
import kotlinx.android.synthetic.main.row_obra.view.*

class PrecoBilheteAdapter : RecyclerView.Adapter<CustomViewHolder>(){

    //array com as imagens dos museus
    val intArray = intArrayOf(R.drawable.portugal, R.drawable.espanha, R.drawable.alemanha)

    //Array com os precos de cada dia da semana
    val doubleArrayPreco1 = doubleArrayOf(1.2, 1.4, 1.3)

    val doubleArrayPreco2 = doubleArrayOf(2.2, 2.4, 2.3)

    val doubleArrayPreco3 = doubleArrayOf(4.2, 4.4, 4.3)

    val doubleArrayPreco4 = doubleArrayOf(3.2, 3.4, 3.3)

    val doubleArrayPreco5 = doubleArrayOf(2.2, 2.4, 2.3)

    val doubleArrayPreco6 = doubleArrayOf(1.7, 1.7, 1.8)

    val doubleArrayPreco7 = doubleArrayOf(3.3, 2.2, 1.1)

    //array do Nome dos museus
    val stringTitulo = arrayOf("Este museu", "Aquele museu", "Outro museu")

    // associa um layout personalizado a cada linha(celula) do adaptador
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_bilhetes_museu_preco, parent, false)
        return CustomViewHolder(cellForRow)
    }

    //o tamanho deste adaptador é igual ao tamanho do array do titulo dos museus
    override fun getItemCount(): Int {
        return stringTitulo.size
    }

    //pupola cada celula costumizada com elementos de cada um dos arrays
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //a cada posicao vai ser inserido array
        val image = intArray.get(position)
        val titulo = stringTitulo.get(position)
        val preco1 = doubleArrayPreco1.get(position)
        val preco2 = doubleArrayPreco2.get(position)
        val preco3 = doubleArrayPreco3.get(position)
        val preco4 = doubleArrayPreco4.get(position)
        val preco5 = doubleArrayPreco5.get(position)
        val preco6 = doubleArrayPreco6.get(position)
        val preco7 = doubleArrayPreco7.get(position)
        //é associado cada array ao seu recurso
        holder?.view?.preco_museus_image?.setImageResource(image)
        holder?.view?.preco_museus_nome_museu.setText(titulo)
        holder?.view?.preco_museus_valor_1.setText(preco1.toString())
        holder?.view?.preco_museus_valor_2.setText(preco2.toString())
        holder?.view?.preco_museus_valor_3.setText(preco3.toString())
        holder?.view?.preco_museus_valor_4.setText(preco4.toString())
        holder?.view?.preco_museus_valor_5.setText(preco5.toString())
        holder?.view?.preco_museus_valor_6.setText(preco6.toString())
        holder?.view?.preco_museus_valor_7.setText(preco7.toString())
    }
}