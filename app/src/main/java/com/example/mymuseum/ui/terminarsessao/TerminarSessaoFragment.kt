package com.example.mymuseum.ui.terminarsessao

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mymuseum.R
import com.example.mymuseum.activities.LoginActivity

class TerminarSessaoFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_contactos, container, false)
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        return root
    }
}
