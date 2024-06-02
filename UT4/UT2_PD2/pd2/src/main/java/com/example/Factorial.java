package com.example;

/*
    Desarrolla en seudocódigo,   en forma recursiva, un algoritmo para calcular el factorial de un cierto número 
    entero que se pasa como parámetro.  
    • Identifica claramente el caso base y la sentencia que lo contempla. 
    • ¿Puedes verificar que siempre el algoritmo progresará hacia el caso base?

Algoritmo Recursivo para Calcular Factorial en Pseudocódigo:

Función factorial(n):
    Si n es igual o menor a 0:
        Devolver 1
    Sino:
        Devolver n multiplicado por factorial(n - 1)
    Fin Si
Fin

En este algoritmo:
Caso Base: Cuando el valor de n es 0, el factorial es 1.
Progresión hacia el Caso Base: En cada llamada recursiva, el valor de n se reduce en 1, por lo que eventualmente alcanzará el caso base.

    Analiza el orden del tiempo de ejecución del algoritmo.

Orden de Tiempo de Ejecución:El tiempo de ejecución de este algoritmo es de O(n), donde n es el número para el que se está calculando el factorial. Esto se debe a que el algoritmo realiza n multiplicaciones en total, una por cada número desde n hasta 1.


    Implementa el algoritmo (en JAVA) y pruébalo: 
    • ¿Qué sucede si el número es negativo? 
    • Verifica que factorial(4), factorial(5), y factorial(0) produzcan los resultados


*/

public class Factorial 
{
    public static int factorial(int n) {
        if (n <= 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main( String[] args )
    {
        System.out.println("Factorial de 4: " + factorial(4));
        System.out.println("Factorial de 5: " + factorial(5));
        System.out.println("Factorial de 0: " + factorial(0));
        System.out.println("Factorial de -1: " + factorial(-1));
    }
}

