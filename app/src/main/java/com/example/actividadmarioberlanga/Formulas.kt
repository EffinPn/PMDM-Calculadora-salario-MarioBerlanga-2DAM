package com.example.actividadmarioberlanga


class Formulas(val formulario: Formulario) {



    fun calcIRPF(): Int {
        var salAnual = formulario.salaBruto * formulario.nPagas - deduccionesHijos() - deduccionesEstadoCivil() - deduccionesDiscapacidad()

        if (salAnual <= 12450) {
            return 19
        }
        if (salAnual <= 20200) {
            return 24
        }
        if (salAnual <= 35200) {
            return 30
        }
        if (salAnual <= 60000) {
            return 37
        }
        if (salAnual <= 300000) {
            return 45
        }
        if (salAnual > 300000) {
            return 47
        }
        return 0
    }

    fun salarioNeto(): Double {
        var irpf = calcIRPF();

        return formulario.salaBruto * irpf / 100;
    }

    fun deduccionesHijos(): Double {
        if (formulario.nHijos == 0) {
            return 0.00
        }
        if (formulario.nHijos == 1) {
            return 2400.00
        }
        if (formulario.nHijos == 2) {
            return 2700.00
        }
        if (formulario.nHijos == 3) {
            return 4000.00
        }
        if (formulario.nHijos >= 4) {
            return 4500.00
        } else{
            return 0.00
        }

    }

    fun deduccionesEstadoCivil(): Int {

        if(formulario.estadoCivil == 0){
            return 500
        }
        if(formulario.estadoCivil  == 1){
            return 0
        }
        if(formulario.estadoCivil  == 2){
            return 500
        }
        if(formulario.estadoCivil == 3){
            return 1500
        }
        if(formulario.estadoCivil == 4){
            return 2000
        } else{
            return 0
        }
    }

    fun deduccionesDiscapacidad(): Int{

        if (formulario.discapacidad  == 0){
            return 0
        }
        if (formulario.discapacidad  == 1){
            return 2000
        }
        if (formulario.discapacidad  == 3){
            return 4000
        } else{
            return 0
        }
    }

    fun totalDeducciones(): Double{
        return deduccionesDiscapacidad() + deduccionesHijos() + deduccionesEstadoCivil()
    }
}