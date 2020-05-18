package com.example.mymuseum.ui.mensagens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mymuseum.R

class MensagensFragment : Fragment() {

    private lateinit var mensagensViewModel: MensagensViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mensagensViewModel =
                ViewModelProviders.of(this).get(MensagensViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mensagens, container, false)
        return root
    }
}
