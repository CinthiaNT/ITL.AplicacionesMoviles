package com.example.calculadora;

public enum OperacionesBasicas {
    raizCuadrada(7),
    factorial(6),
    potencia(5),
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
