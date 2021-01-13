package com.glauco.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var peso: EditText
        lateinit var altura: EditText
        lateinit var resultado: TextView


        var calcular = findViewById<Button>(R.id.bt_calcular)
        var deletar = findViewById<ImageView>(R.id.icone_limpar)

        calcular.setOnClickListener {
            peso = findViewById(R.id.edit_peso)
            val pesoInt = Integer.parseInt(peso.text.toString())

            altura = findViewById(R.id.edit_altura)
            var alturaFloat = java.lang.Float.parseFloat((altura.text.toString()))


            resultado = findViewById(R.id.mensagem)
            val imc = pesoInt / (alturaFloat * alturaFloat)

            val mensagem = when {
                imc <= 18.5 -> "Peso baixo"
                imc <= 24.9 -> "Peso normal"
                imc <= 29.9 -> "Sobrepeso"
                imc <= 34.9 -> "Obesidade (Grau 1)"
                imc <= 39.9 -> "Obesidade (Grau 2)"
                else -> "Obesidade Mórbida (Grau 3)"

            }

            resultado.text = "IMC:" + imc.toString() + "\n" + mensagem
        }

        deletar.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                peso.setText("")
                altura.setText("")
                mensagem.setText("")
            }
            false
        }

    }
}