package com.example.mymuseum.ui.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuseum.R
import com.example.mymuseum.adapters.MuseuAdapter
import kotlinx.android.synthetic.main.activity_categoria.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.setBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.catMusBack))
        //é criado um layout manager para este fragmento
        root.recyclerView.layoutManager = LinearLayoutManager(activity)
        //depois é chamado o adaptador customizado
        root.recyclerView.adapter = MuseuAdapter()
        return root
    }

}
