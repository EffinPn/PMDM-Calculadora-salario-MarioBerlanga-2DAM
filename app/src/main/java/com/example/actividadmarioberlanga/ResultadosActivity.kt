package com.example.actividadmarioberlanga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultados)

        //Recibimos el formulario. Sé que Serializable está obsoleto y ahora se usa Parcelable, pero aun
        //no soy capaz de entender cómo funciona... como la app es muy sencilla y Serializable hace el trabajo,
        //lo he dejado así.
        val formulario = intent.getSerializableExtra("formulario") as Formulario
        val formulas = Formulas(formulario)
        val buttonVolver = findViewById<Button>(R.id.volver)

        //Este botón vuelve a la pantalla anterior cuando se pulsa.
        buttonVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Le pasamos a los elementos del XML los valores
        //que nos devuelven los métodos de la clase Fórmulas, en forma de String.
        findViewById<TextView>(R.id.resultadobruto).text = formulario.salaBruto.toString()+"€"
        findViewById<TextView>(R.id.resultadoneto).text = formulas.salarioNeto().toString()+"€"
        findViewById<TextView>(R.id.resultadoirpf).text = formulas.calcIRPF().toString()+"%"
        findViewById<TextView>(R.id.resultadodeducc).text = formulas.totalDeducciones().toString()+"€"
    }
}