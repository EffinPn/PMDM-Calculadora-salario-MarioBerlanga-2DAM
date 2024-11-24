package com.example.actividadmarioberlanga

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Buscamos el Button con la id correspondiente en los XML gracias a findViewById
        val buttonCalc = findViewById<Button>(R.id.calcular)
        val buttonReset = findViewById<Button>(R.id.reset)
        //Objeto formulario donde vamos a guardar lo que el usuario introduzca en la app.
        var formulario: Formulario = Formulario(0.00, 0, 0, 0, 0, 0, 0)

        //Cuando se haga Click en el botón, le pasamos nuestro Formulario a rellenarformulario()
        buttonCalc.setOnClickListener {

            rellenarFormulario(formulario)
            //Al pulsar el botón cambiamos de activity y le pasamos nuestro formulario rellenado.
            val intent = Intent(this, ResultadosActivity::class.java)
            intent.putExtra("formulario", formulario)
            startActivity(intent)
        }

        buttonReset.setOnClickListener {

            resetFormulario()
        }


    }

    //Rellenamos las variables del formulario con los valores que hay en sus respectivos elementos del XML.

    //Para los Spinner simplemente se añaden SU POSICIÓN EN EL ARRAY, es decir, por ejemplo en nPagas
    //escoger la primera opción del Spinner significa que no se va a guardar 12, se va a guardar un 0.
    //En las demás convertimos el texto introducido a Double o Int y con el operador Elvis designamos un valor
    //en caso de Null.
    fun rellenarFormulario(formulario: Formulario) {
        formulario.salaBruto = findViewById<EditText>(R.id.salario).text.toString().toDoubleOrNull() ?: 0.00
        formulario.nPagas = findViewById<Spinner>(R.id.npagas).selectedItemPosition
        formulario.edad = findViewById<EditText>(R.id.edad).text.toString().toIntOrNull() ?: 0
        formulario.grupoProf = findViewById<Spinner>(R.id.grupoprof).selectedItemPosition
        formulario.discapacidad = findViewById<Spinner>(R.id.gradodiscapacidad).selectedItemPosition
        formulario.estadoCivil = findViewById<Spinner>(R.id.estadocivil).selectedItemPosition
        formulario.nHijos = findViewById<EditText>(R.id.nhijos).text.toString().toIntOrNull() ?: 0

    }

    //Esta función pone todos los valores a 0
    fun resetFormulario() {
        findViewById<EditText>(R.id.salario).setText("")
        findViewById<Spinner>(R.id.npagas).setSelection(0)
        findViewById<EditText>(R.id.edad).setText("")
        findViewById<Spinner>(R.id.grupoprof).setSelection(0)
        findViewById<Spinner>(R.id.gradodiscapacidad).setSelection(0)
        findViewById<Spinner>(R.id.estadocivil).setSelection(0)
        findViewById<EditText>(R.id.nhijos).setText("")
    }
}
