package com.example.calculadora;

public enum OperacionesBasicas {
    raizCuadrada(7),
    factorial(6),
    potencia(5),
    division(4),
    multiplicacion(3),
    resta(2),
    suma(1);
    private static int valor;
    OperacionesBasicas(int valor){}
    public static int getValor(){ return valor;}



}
