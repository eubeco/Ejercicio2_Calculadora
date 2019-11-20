package com.example.ejercicio2_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    companion object {
        const val RESULTADO = "resultado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        MostrarResultado()

        }

    fun MostrarResultado(){
        val resultado = intent .getIntExtra(RESULTADO , 0 )
        val textViewRtdo = findViewById(R.id.textView_resultado) as TextView
        textViewRtdo.setText(resultado.toString())
    }
}
