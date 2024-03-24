package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class pd10 {

    public int contarPalabrasArchivo(String nombreCompletoArchivo) {
        FileReader fr;
        int contadorPalabras = 0;
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                contadorPalabras += contarPalabrasFrase(lineaActual);
                lineaActual = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        return contadorPalabras;
    }

    public static int contarPalabrasFrase(String frase) {
        int contador = 0;
        boolean enPalabra = false;

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);

            // Si el caracter es una letra, estamos en una palabra
            if (Character.isLetter(caracter)) {
                enPalabra = true;
            }
            // Si encontramos un espacio y estábamos en una palabra, aumentamos el contador
            else if (caracter == ' ' && enPalabra) {
                contador++;
                enPalabra = false;
            }
        }

        // Contamos la última palabra si la frase no termina con un espacio
        if (enPalabra) {
            contador++;
        }

        return contador;
    }

    /*
     * La nueva funcionalidad agregada a la clase ContadorPalabras permite encontrar y devolver las palabras comunes entre dos conjuntos de palabras representados por arrays de Strings.
     * Para lograr esto, primero se eliminan los duplicados en cada conjunto, convirtiendo los arrays en conjuntos (Set). Luego, se encuentra la intersección de estos conjuntos, es decir, se identifican y retienen solo las palabras que están presentes en ambos conjuntos. Finalmente, estas palabras comunes se convierten de nuevo en un array de Strings, que es devuelto como resultado.
     */

    public static String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Agregar palabras de palabras1 al set1
        for (String palabra : palabras1) {
            set1.add(palabra);
        }

        // Agregar palabras de palabras2 al set2
        for (String palabra : palabras2) {
            set2.add(palabra);
        }

        // Crear un nuevo conjunto que contenga la intersección de set1 y set2
        set1.retainAll(set2);

        // Convertir el conjunto resultante en un array de Strings
        String[] resultado = new String[set1.size()];
        set1.toArray(resultado);

        return resultado;
    }

    public static void main(String[] args) {
        pd10 pd10 = new pd10();
        int cantidadPalabras = pd10.contarPalabrasArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT1\\PD10\\pd10\\src\\main\\java\\com\\example\\entrada.txt");
        System.out.println("La cantidad de palabras en la frase es: " + cantidadPalabras);

        String[] Ar1 = {"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2 = {"Hola", "mundo", "de", "la", "informática"};

        String[] resultado = palabrasComunes(Ar1, Ar2);

        System.out.println("Palabras comunes:");
        for (String palabra : resultado) {
            System.out.println(palabra);
        }
    }
}
