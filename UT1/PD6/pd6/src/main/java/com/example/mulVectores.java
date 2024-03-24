package com.example;

/*
  
   La multiplicación de vectores es una operación matemática que implica multiplicar cada componente de dos vectores para obtener un nuevo vector. Para que esta operación sea posible, deben cumplirse las siguientes condiciones:

    Dimensiones iguales: Los dos vectores deben tener la misma dimensión, es decir, el mismo número de componentes. Si uno tiene n componentes, el otro también debe tener n componentes.

    Compatibilidad de orientación: Los vectores deben ser compatibles en su orientación para la multiplicación. Esto significa que uno de los vectores debe ser un vector fila y el otro un vector columna, o viceversa. En otras palabras, uno de los vectores debe ser un arreglo unidimensional y el otro un arreglo bidimensional, o viceversa.

    Tipo de dato compatible: En este caso, ambos vectores son de tipo int (entero), lo que es adecuado para la multiplicación. Si los vectores contienen otro tipo de datos, como flotantes o dobles, también deben ser compatibles en este aspecto.

    Si estas condiciones se cumplen, entonces es posible realizar la multiplicación de vectores. En caso contrario, la operación no es posible y se deben tomar medidas para ajustar los vectores o verificar la validez de la operación en el contexto del problema dado.

 */
public class mulVectores {

    public static int[] multiplicarVectores(int[] vector1, int[] vector2) {
        // Verificar si los vectores son compatibles para la multiplicación
        if (vector1.length != vector2.length) {
            System.out.println("No se pueden multiplicar los vectores. Deben tener la misma longitud.");
            return null;
        }

        // Realizar la multiplicación de los vectores
        int[] resultado = new int[vector1.length];
        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] * vector2[i];
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] vector1 = { 1, 2, 3, 4 };
        int[] vector2 = { 2, 3, 4, 5 };

        int[] resultado = multiplicarVectores(vector1, vector2);
        if (resultado != null) {
            System.out.print("El resultado de la multiplicación de los vectores es: ");
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i] + " ");
            }
        }
    }
}
