package com.example.ejercicio2_calculadora
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener

import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.*
import androidx.annotation.ContentView
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operaciones = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, operaciones)

        val list_operaciones = findViewById(R.id.spinner) as Spinner
        list_operaciones.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)





        list_operaciones.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                /*val edit_telf = findViewById(R.id.EditText_Phone) as EditText
                edit_telf.setText(parent!!.getItemAtPosition(position).toString())*/
                /*Toast.makeText(applicationContext, parent!!.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()*/
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        val operando1 = findViewById(R.id.editText_operando1) as EditText
        val operando2 = findViewById(R.id.editText_operando2) as EditText



        val btn_operar = findViewById(R.id.button) as Button
        btn_operar.setOnClickListener{

            if (!(operando1.text.toString().trim().isEmpty()) && !(operando2.text.toString().trim().isEmpty())) {
                var resultadoInt = 0
                (when (list_operaciones.selectedItem.toString()) {
                    "Sumar" -> resultadoInt =
                        operando1.text.toString().toInt() + operando2.text.toString().toInt()
                    "Restar" -> resultadoInt =
                        operando1.text.toString().toInt() - operando2.text.toString().toInt()
                    "Multiplicar" -> resultadoInt =
                        operando1.text.toString().toInt() * operando2.text.toString().toInt()
                    "Dividir" -> resultadoInt =
                        operando1.text.toString().toInt() / operando2.text.toString().toInt()
                })
                MostrarResultado(resultadoInt)
            }
            /*else
                Toast.makeText(applicationContext, "Falta operando",Toast.LENGTH_LONG).show()*/
        }

        operando1.setOnFocusChangeListener { v, hasFocus ->
            if (!(operando1.text.toString().trim().isEmpty()) && !(operando2.text.toString().trim().isEmpty())) {
                btn_operar.isEnabled = true
            }
            else
            {
                btn_operar.isEnabled = false
            }

        }

        operando2.setOnFocusChangeListener { v, hasFocus ->
            if (!(operando1.text.toString().trim().isEmpty()) && !(operando2.text.toString().trim().isEmpty())) {
                btn_operar.isEnabled = true
            }
            else
            {
                btn_operar.isEnabled = false
            }

        }
    }

    fun MostrarResultado (Resultado : Int) {
        // Create an Intent to start the second activity
        val resultadoIntent = Intent ( this , Main2Activity :: class .java)

        // Add the resultado to the extras for the Intent.
        resultadoIntent.putExtra( Main2Activity.RESULTADO, Resultado)
        // Start the new activity.
        startActivity(resultadoIntent)
    }
}
