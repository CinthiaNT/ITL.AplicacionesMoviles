package com.example.directorioempleadoslista;

import java.io.Serializable;

public class Empleado implements Serializable {
    String nombre;
    String apellidoP;
    String apellidoM;
    int numNomina;
    String telefono;
    public Empleado(String nombre,String apellidoP,String apellidoM,int numNomina,String telefono){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numNomina = numNomina;
        this.telefono = telefono;
    }

}