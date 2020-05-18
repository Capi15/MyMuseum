package com.example.mymuseum.ui.contactos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mymuseum.R

class ContactosFragment : Fragment() {

    private lateinit var contactosViewModel: ContactosViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactosViewModel =
                ViewModelProviders.of(this).get(ContactosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contactos, container, false)
        return root
    }
}
