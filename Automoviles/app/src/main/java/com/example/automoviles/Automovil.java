package com.example.automoviles;

public class Automovil {
    int id;
    String marca;
    String modelo;
    String color;
    String carroceria;
    public Automovil(){

    }

    public Automovil(int id, String marca, String modelo, String color, String carroceria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.carroceria = carroceria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }
}
