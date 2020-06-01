package com.example.mymuseum.ui.comprarbilhete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mymuseum.R


class ComprarBilheteFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_comprar_bilhete, container, false)
        root.setBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.newBackground))
        return root
    }
}
