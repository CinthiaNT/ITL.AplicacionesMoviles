package com.example.navegacion;

import java.io.Serializable;

public class Empleado implements Serializable {
    String nombre;
    String apellido;
    int edad;
    public Empleado(String nombre,String apellido,int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

}
