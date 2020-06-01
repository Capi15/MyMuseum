package com.example.mymuseum.ui.comprarbilhete

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mymuseum.R


class ComprarBilheteFragment : Fragment() {

    var totalPagar: TextView? = null
    private var myPagarEditText: EditText? = null
    var strPagar: String = ""
    var dblPagar: Double = 0.00
    var strBilhete: String = ""
    var dblBilhete : Double = 0.00
    var dblMuseu : Double = 0.00

    lateinit var myQuantidadeEditText: EditText
    private lateinit var limpar: Button
    private lateinit var radioGroup1: RadioGroup
    private lateinit var radioGroup2: RadioGroup
    private lateinit var radioM1: RadioButton
    private lateinit var radioM2: RadioButton
    private lateinit var radioM3: RadioButton
    private lateinit var radioB1: RadioButton
    private lateinit var radioB2: RadioButton
    private lateinit var radioB3: RadioButton

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_comprar_bilhete, container, false)
        root.setBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.newBackground))

        myQuantidadeEditText = root.findViewById(R.id.compraB_quantidade_input)
        totalPagar = root.findViewById(R.id.compraB_valor_total)
        limpar = root.findViewById(R.id.compraB_limpar_button)
        radioGroup1 = root.findViewById(R.id.compraB_grupo_museus)
        radioGroup2 = root.findViewById(R.id.compraB_grupo_bilhetes)
        radioM1 = root.findViewById(R.id.compraB_radiobutton_museu_1)
        radioM2 = root.findViewById(R.id.compraB_radiobutton_museu_2)
        radioM3 = root.findViewById(R.id.compraB_radiobutton_museu_3)
        radioB1 = root.findViewById(R.id.compraB_radiobutton_tipo_1)
        radioB2 = root.findViewById(R.id.compraB_radiobutton_tipo_2)
        radioB3 = root.findViewById(R.id.compraB_radiobutton_tipo_3)

        radioGroup1.setOnClickListener{
            val radioId = radioGroup1.checkedRadioButtonId
            radioGroup1 = root.findViewById(radioId)
            when (radioGroup1){
                radioB1 -> dblMuseu = 0.30
                radioB2 -> dblMuseu = 0.40
                radioB3 -> dblMuseu = 0.20
            }
        }

        radioGroup2.setOnClickListener {
            val radioId = radioGroup2.checkedRadioButtonId
            radioGroup2 = root.findViewById(radioId)
            when (radioGroup2.checkedRadioButtonId){
                R.id.compraB_radiobutton_tipo_1 -> dblBilhete = 1.75
                R.id.compraB_radiobutton_tipo_2 -> dblBilhete = 3.00
                R.id.compraB_radiobutton_tipo_3 -> dblBilhete = 4.15
            }
        }

        dblPagar = dblMuseu + dblBilhete
        Log.i("log", dblPagar.toString())
        totalPagar!!.text = dblPagar.toString()
        Log.i("log", totalPagar!!.text.toString())

        limpar.setOnClickListener {
            myQuantidadeEditText.setText("")
            totalPagar!!.text = "0.00"
        }

        myQuantidadeEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                strPagar = myQuantidadeEditText.text.toString()
                totalPagar!!.text = strPagar
                Log.i("log2", strPagar)
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        Log.i("log1", myQuantidadeEditText.text.toString())
        return root
    }

    //atualiza o valor do total
    fun totalAPagar(){
        totalPagar = activity?.findViewById(R.id.compraB_valor_total)
        myPagarEditText = activity?.findViewById(R.id.compraB_quantidade_input)
        if(totalPagar!!.text != myPagarEditText?.text){
            totalPagar!!.text = myPagarEditText?.text.toString()

        }
    }
}
