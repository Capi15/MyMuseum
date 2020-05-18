package com.example.mymuseum.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuseum.R
import com.example.mymuseum.adapters.CategoriaAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.setBackgroundColor(Color.CYAN);
        //é criado um layout manager para este fragmento
        root.recylerView.layoutManager = LinearLayoutManager(activity)
        //depois é chamado o adaptador customizado
        root.recylerView.adapter = CategoriaAdapter()
        return root
    }
}
