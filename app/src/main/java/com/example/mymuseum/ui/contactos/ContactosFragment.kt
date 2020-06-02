package com.example.mymuseum.ui.contactos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mymuseum.R
import com.example.mymuseum.activities.ContactosSucesso
import com.example.mymuseum.activities.RegisterActivity
import kotlinx.android.synthetic.main.fragment_contactos.*
import kotlinx.android.synthetic.main.fragment_contactos.view.*

class ContactosFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_contactos, container, false)
        val mensagem: EditText = root.findViewById(R.id.contactos_mensagem_corpo)
        root.setBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.newBackground))
        //implementação do click de um botão, para instanciar uma nova atividade
        root.contactos_button.setOnClickListener {
            val intent = Intent (requireActivity().applicationContext, ContactosSucesso::class.java)
            startActivity(intent)
            mensagem.text = null

        }
        return root
    }
}
