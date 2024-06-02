package com.example;

/*
    Desarrolla  en  seudocódigo,  en  forma  recursiva,  un  algoritmo  para  invertir  los  componentes  de  un  vector 
    pasado por parámetro, entre dos índices indicados también pasados como parámetros. (ver  la ppt  de clase 
    sobre recursividad). 
    •  Identifica claramente el / los  caso(s) base y la(s) sentencia(s) que lo contempla(n). 
    • ¿Puedes verificar que siempre el algoritmo progresará hacia el caso base?

Algoritmo Recursivo para Invertir Componentes de un Vector entre dos índices:

Procedimiento invertirVector(Vector, inicio, fin):
    Si inicio >= fin:
        Retornar Vector  // Caso base: no hay elementos para invertir o solo hay un elemento
    Sino:
        Intercambiar(Vector[inicio], Vector[fin])
        invertirVector(Vector, inicio + 1, fin - 1)  // Llamada recursiva con los índices actualizados
En este algoritmo:

Caso Base: El caso base ocurre cuando el índice de inicio es mayor o igual que el índice final. Esto ocurre cuando no hay elementos para invertir o cuando solo hay un elemento en el rango dado.
Progresión hacia el Caso Base: En cada llamada recursiva, los índices de inicio y fin se actualizan de tal manera que se acercan al caso base.

    Analiza el orden del tiempo de ejecución del algoritmo.

Orden de Tiempo de Ejecución:El tiempo de ejecución de este algoritmo es de O(n), donde n es la cantidad de elementos que se están invirtiendo en el vector. Esto se debe a que el algoritmo debe iterar sobre la mitad de los elementos del vector para realizar el intercambio.

    Implementa el algoritmo (en JAVA) y pruébalo: 
    • Crea  un  pequeño  vector  y  prueba  el  algoritmo.  Prueba  situaciones  de  borde  (extremos),  parámetros 
    fuera de rango, vector vacío, vector con sólo un elemento, etc

*/

public class InvertirVector {
    public static void invertirVector(int[] vector, int inicio, int fin) {
        if (inicio >= fin) {
            return; // Caso base: no hay elementos para invertir o solo hay un elemento
        } else {
            // Intercambiar los elementos en las posiciones inicio y fin
            int temp = vector[inicio];
            vector[inicio] = vector[fin];
            vector[fin] = temp;
            // Llamada recursiva con los índices actualizados
            invertirVector(vector, inicio + 1, fin - 1);
        }
    }

    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 5};
        int inicio = 1;
        int fin = 3;

        // Invertir el vector entre los índices dados
        invertirVector(vector, inicio, fin);

        // Imprimir el vector invertido
        System.out.print("Vector invertido entre los índices " + inicio + " y " + fin + ": ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }
}
