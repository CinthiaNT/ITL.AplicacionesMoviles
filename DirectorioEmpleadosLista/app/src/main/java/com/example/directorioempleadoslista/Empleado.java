package com.example.directorioempleadoslista;

import java.io.Serializable;

public class Empleado implements Serializable {
    String nombre;
    String apellidoP;
    String apellidoM;
    int numNomina;
    String telefono;

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getNumNomina() {
        return numNomina;
    }

    public void setNumNomina(int numNomina) {
        this.numNomina = numNomina;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(){

    }
    public Empleado(String nombre, String apellidoP, String apellidoM, int numNomina, String telefono){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numNomina = numNomina;
        this.telefono = telefono;
    }

}