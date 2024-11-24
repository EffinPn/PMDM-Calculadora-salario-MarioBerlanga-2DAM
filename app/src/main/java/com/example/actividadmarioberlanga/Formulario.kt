package com.example.actividadmarioberlanga

import java.io.Serializable

class Formulario(
    var salaBruto: Double,
    var nPagas: Int,
    var edad: Int,
    var grupoProf: Int,
    var discapacidad: Int,
    var estadoCivil: Int,
    var nHijos: Int
    ) : Serializable {
    init {
        if (salaBruto <= 0){
            print("No válido")
        }
        if (edad <= 16){
            print("No deberías estar trabajando")
        }
        if(nHijos < 0){
            print("Si no tienes hijos, pon 0")
        }
        }

    override fun toString(): String {
        return "Formulario(salaBruto= $salaBruto, nPagas= $nPagas, edad= $edad, grupoProf= $grupoProf, discapacidad= $discapacidad, estadoCivil= $estadoCivil, nHijos= $nHijos)"
    }


}