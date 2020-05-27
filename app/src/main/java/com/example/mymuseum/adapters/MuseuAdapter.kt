package com.example.mymuseum.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuseum.R
import kotlinx.android.synthetic.main.museu_row.view.*

class MuseuAdapter : RecyclerView.Adapter<CustomViewHolder>(){

    //imagem default
    val intImage = intArrayOf(
        R.drawable.franca,
        R.drawable.portugal,
        R.drawable.espanha,
        R.drawable.china,
        R.drawable.alemanha
    )

    //arrays de strings remtentes aos museus
    val stringTitulo = arrayOf("França", "Portugal", "Espanha", "China", "Alemanha")
    val stringDescricao = arrayOf("O melhor museu Europeu", "Museus do minho", "Venha Visitar-nos", "Melhor museu Asiatico", "Segundo melhor museu Europeu")

    // associa um layout personalizado a cada linha(celula) do adaptador
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.museu_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    //o tamanho deste adaptador é igual ao tamanho do Nome de cada museu
    override fun getItemCount(): Int {
        return stringTitulo.size
    }

    //pupola cada celula costumizada com elementos de cada um dos arrays
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //a cada posicao vai ser inserida uma imagem
        val image = intImage.get(position)
        val titulo = stringTitulo.get(position)
        val descricao = stringDescricao.get(position)
        //é associada a imagem do array ao seu recurso
        holder?.view?.museu_image?.setImageResource(image)
        holder?.view?.museu_titulo.setText(titulo)
        holder?.view?.museu_descricao.setText(descricao)
    }
}

// permite receber uma view, neste caso uma ImageView
class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){

}