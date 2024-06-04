package com.example;

/*
    Desarrolla  en  seudocódigo,  en  forma  recursiva,  un  algoritmo  para  calcular  la  potencia  de  un  número.  El 
    mismo ha de recibir como parámetros el número y el exponente (ver la ppt de clase sobre recursividad).  
    • Identifica claramente el caso base y la sentencia que lo contempla. 
    • ¿Puedes verificar que siempre el algoritmo progresará hacia el caso base?

Algoritmo Recursivo para Calcular Potencia en Pseudocódigo:

Función Potencia(base, exponente):
    Si el exponente es igual a 0:
        Devolver 1
    Sino si el exponente es mayor que 0:
        Devolver base multiplicado por Potencia(base, exponente - 1)
    Sino:
        Devolver 1 dividido por Potencia(base, -exponente)
En este algoritmo:

Caso Base: Cuando el exponente es 0, la potencia es 1.
Progresión hacia el Caso Base: En cada llamada recursiva, el exponente se reduce hacia el caso base.

    Analiza el orden del tiempo de ejecución del algoritmo.

Orden de Tiempo de Ejecución:El tiempo de ejecución de este algoritmo es de O(n), donde n es el valor absoluto del exponente. Esto se debe a que el algoritmo realiza n multiplicaciones en total.
 
    Implementa el algoritmo (en JAVA) y pruébalo: 
    • ¿Tu algoritmo soporta números reales o sólo enteros – para ambos parámetros? 
    • ¿qué sucede si uno, otro o ambos parámetros son negativos?

*/

public class Potencia {
    public static double potencia(double base, int exponente) {
        if (exponente == 0)
            return 1;
        else if (exponente > 0)
            return base * potencia(base, exponente - 1);
        else
            return 1 / potencia(base, -exponente);
    }

    public static void main(String[] args) {
        // Prueba con números enteros
        System.out.println("Potencia de 2^3: " + potencia(2, 3));
        System.out.println("Potencia de 5^0: " + potencia(5, 0));
        System.out.println("Potencia de 3^(-2): " + potencia(3, -2));

        // Prueba con números reales
        System.out.println("Potencia de 2.5^2: " + potencia(2.5, 2));
        System.out.println("Potencia de 1.5^(-3): " + potencia(1.5, -3));
    }
}
