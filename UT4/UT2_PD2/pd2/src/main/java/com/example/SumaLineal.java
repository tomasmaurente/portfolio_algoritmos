package com.example;

/*
    Desarrolla en seudocódigo,  en forma recursiva, el algoritmo Algoritmo SumaLineal(A, n), que se describe en 
    la ppt de clase sobre recursividad.  
    • Identifica claramente el caso base y la sentencia que lo contempla. 
    • ¿Puedes verificar que siempre el algoritmo progresará hacia el caso base?

Algoritmo Recursivo para Suma Lineal en Pseudocódigo:

Función SumaLineal(A, n):
    Si n es igual a 0:
        Devolver 0
    Sino:
        Devolver A[n-1] + SumaLineal(A, n-1)
En este algoritmo:

Caso Base: Cuando el valor de n es 0, la suma es 0.
Progresión hacia el Caso Base: En cada llamada recursiva, el valor de n se reduce en 1, por lo que eventualmente alcanzará el caso base.
   
    Analiza el orden del tiempo de ejecución del algoritmo.

Orden de Tiempo de Ejecución:El tiempo de ejecución de este algoritmo es de O(n), donde n es el tamaño del vector A. Esto se debe a que el algoritmo realiza una llamada recursiva por cada elemento en el vector A.

    Implementa el algoritmo (en JAVA) y pruébalo: 
    • ¿Qué sucede si el parámetro n es negativo? 
    • ¿Qué sucede  si el vector A está vacío?

*/

public class SumaLineal {
    public static int sumaLineal(int[] A, int n) {
        if (n == 0)
            return 0;
        else
            return A[n - 1] + sumaLineal(A, n - 1);
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};
        int suma = sumaLineal(arreglo, arreglo.length);
        System.out.println("La suma es: " + suma);

        // Prueba con n negativo
        int[] vacio = {};
        int sumaNegativa = sumaLineal(vacio, -1);
        System.out.println("La suma con n negativo es: " + sumaNegativa);

        // Prueba con vector vacío
        int sumaVacio = sumaLineal(vacio, vacio.length);
        System.out.println("La suma con vector vacío es: " + sumaVacio);
    }
}

