package com.example.calculadora;

public enum OperacionesBasicas {
    potencia(7),
    raizCuadrada(6),
    factorial(5),
    division(4),
    multiplicacion(3),
    resta(2),
    suma(1);
    private final int valor;
    OperacionesBasicas(int valor){
        this.valor = valor;
    }
    public int getValor(){ return valor;}



}
