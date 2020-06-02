package com.example.mymuseum.ui.comprarbilhete

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mymuseum.R


class ComprarBilheteFragment : Fragment() {

    var totalPagar: TextView? = null
    var strPagar: String = ""
    var dblPagar: Double = 0.00
    var dblBilhete : Double = 0.00
    var dblMuseu : Double = 0.00
    var novoPagar: Double = 0.00
    var result: Double = 1.00

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

        radioGroup1.setOnCheckedChangeListener{ radioGroup: RadioGroup, checkedId: Int ->
            val radioButton = root.findViewById<RadioButton>(checkedId)
            dblMuseu = when (checkedId) {
                radioM1.id -> {
                    0.30
                }
                radioM2.id -> {
                    0.40
                }
                radioM3.id -> {
                    0.20
                }
                else -> {
                    0.00
                }
            }
            Toast.makeText(activity, dblMuseu.toString(), Toast.LENGTH_SHORT).show()
        }

        radioGroup2.setOnCheckedChangeListener{ radioGroup: RadioGroup, checkedId: Int ->
            val radioButton = root.findViewById<RadioButton>(checkedId)
              when (checkedId) {
                radioB1.id -> {
                    dblBilhete = 1.75
//                    novoPagar = result * (dblBilhete + dblMuseu)
//                    strPagar = novoPagar.toString()
//                    totalPagar!!.text = strPagar
                }
                radioB2.id -> {
                    dblBilhete = 3.00
//                    novoPagar = result * (dblBilhete + dblMuseu)
//                    strPagar = novoPagar.toString()
//                    totalPagar!!.text = strPagar
                }
                radioB3.id -> {
                    dblBilhete = 4.15
//                    novoPagar = result * (dblBilhete + dblMuseu)
//                    strPagar = novoPagar.toString()
//                    totalPagar!!.text = strPagar
                }
                else -> {
                    dblBilhete = 0.00
                }
            }
            Toast.makeText(activity, dblBilhete.toString(), Toast.LENGTH_SHORT).show()
        }

        limpar.setOnClickListener {
            myQuantidadeEditText.setText("")
            totalPagar!!.text = "0.00"
        }

        myQuantidadeEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val quantidade: String = myQuantidadeEditText.text.toString()
                if(!quantidade.isEmpty()){
                    dblPagar = quantidade.toDouble()
                    result = dblPagar * (dblBilhete + dblMuseu)
                    Toast.makeText(activity, result.toString(), Toast.LENGTH_SHORT).show()
                }else{
                    result = dblBilhete + dblMuseu
                }
                strPagar = result.toString()
                totalPagar!!.text = strPagar
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
        return root
    }
}
