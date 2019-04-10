package com.example.directorioapp.Model;

import java.io.Serializable;

public class Empleado implements Serializable {
    private String rutaImg;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String telefono;
    private String fecha_nacimiento;
    private String correo;
    private String direccion;
    private String estado_civil;
    private int no_nomnina;
    private String curp;
    private String rfc;
    private String nss;
    private String area;
    private String puesto;
    private String escolaridad;
    private String enfermedades_cronicas;
    private String contacto_emergencia;
    private String estatus;

    public Empleado(String nombre, String apellido_p,String apellido_m, int no_nomnina) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.no_nomnina = no_nomnina;
    }

    public int getNo_nomnina() { return no_nomnina; }

    public void setNo_nomnina(int no_nomnina) { this.no_nomnina = no_nomnina; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido_p() { return apellido_p; }

    public void setApellido_p(String apellido_p) { this.apellido_p = apellido_p; }

    public String getApellido_m() { return apellido_m; }

    public void setApellido_m(String apellido_m) { this.apellido_m = apellido_m; }
}