package com.example.mymuseum.ui.comprarbilhete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mymuseum.R

class ComprarBilheteFragment : Fragment() {

    private lateinit var comprarBilheteViewModel: ComprarBilheteViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        comprarBilheteViewModel =
                ViewModelProviders.of(this).get(ComprarBilheteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contactos, container, false)
        return root
    }
}
