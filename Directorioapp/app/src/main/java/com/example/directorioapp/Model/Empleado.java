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
    private String no_nomnina;
    private String curp;
    private String rfc;
    private String nss;
    private String area;
    private String puesto;
    private String escolaridad;
    private String enfermedades_cronicas;
    private String contacto_emergencia;
    private String estatus;
   public Empleado(){

   }
    public Empleado(String nombre,String apellido_p,String apellido_m,String no_nomnina){
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.no_nomnina = no_nomnina;
    }
    public Empleado(String nombre, String apellido_p, String apellido_m, String telefono, String fecha_nacimiento, String correo, String direccion, String estado_civil,String no_nomnina) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.direccion = direccion;
        this.estado_civil = estado_civil;
        this.no_nomnina = no_nomnina;
    }
    public Empleado(String no_nomnina, String curp, String rfc, String nss, String area, String puesto, String escolaridad, String enfermedades_cronicas, String contacto_emergencia, String estatus) {
        this.no_nomnina = no_nomnina;
        this.curp = curp;
        this.rfc = rfc;
        this.nss = nss;
        this.area = area;
        this.puesto = puesto;
        this.escolaridad = escolaridad;
        this.enfermedades_cronicas = enfermedades_cronicas;
        this.contacto_emergencia = contacto_emergencia;
        this.estatus = estatus;
    }

    public Empleado(String nombre, String apellido_p, String apellido_m, String telefono, String fecha_nacimiento, String correo, String direccion, String estado_civil, String no_nomnina, String curp, String rfc, String nss, String area, String puesto, String escolaridad, String enfermedades_cronicas, String contacto_emergencia, String estatus) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.direccion = direccion;
        this.estado_civil = estado_civil;
        this.no_nomnina = no_nomnina;
        this.curp = curp;
        this.rfc = rfc;
        this.nss = nss;
        this.area = area;
        this.puesto = puesto;
        this.escolaridad = escolaridad;
        this.enfermedades_cronicas = enfermedades_cronicas;
        this.contacto_emergencia = contacto_emergencia;
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getNo_nomnina() {
        return no_nomnina;
    }

    public void setNo_nomnina(String no_nomnina) {
        this.no_nomnina = no_nomnina;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getEnfermedades_cronicas() {
        return enfermedades_cronicas;
    }

    public void setEnfermedades_cronicas(String enfermedades_cronicas) {
        this.enfermedades_cronicas = enfermedades_cronicas;
    }

    public String getContacto_emergencia() {
        return contacto_emergencia;
    }

    public void setContacto_emergencia(String contacto_emergencia) {
        this.contacto_emergencia = contacto_emergencia;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}