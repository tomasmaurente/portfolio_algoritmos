package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class pd6Ej3ParteA {

    public static void transformarT9Texto(String rutaArchivo) {
        try (
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT1\\PD6\\salida.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.toUpperCase(); // Convertir a mayúsculas para manejar todos los casos
                StringBuilder resultado = new StringBuilder();
                for (char c : linea.toCharArray()) {
                    resultado.append(obtenerDigitoT9(c));
                }
                bw.write(resultado.toString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    private static String obtenerDigitoT9(char letra) {
        switch (Character.toUpperCase(letra)) {
            case 'A':
                return "2 ";
            case 'B':
                return "22 ";
            case 'C':
                return "222 ";
            case 'D':
                return "3 ";
            case 'E':
                return "33 ";
            case 'F':
                return "333 ";
            case 'G':
                return "4 ";
            case 'H':
                return "44 ";
            case 'I':
                return "444 ";
            case 'J':
                return "5 ";
            case 'K':
                return "55 ";
            case 'L':
                return "555 ";
            case 'M':
                return "6 ";
            case 'N':
                return "66 ";
            case 'O':
                return "666 ";
            case 'P':
                return "7 ";
            case 'Q':
                return "77 ";
            case 'R':
                return "777 ";
            case 'S':
                return "7777 ";
            case 'T':
                return "8 ";
            case 'U':
                return "88 ";
            case 'V':
                return "888 ";
            case 'W':
                return "9 ";
            case 'X':
                return "99 ";
            case 'Y':
                return "999 ";
            case 'Z':
                return "9999 ";
            case ' ':
                return "0 ";
            case '.':
                return "1 ";
            default:
                return Character.toString(letra) + " "; // Mantener otros caracteres tal como están con un espacio en blanco
        }
    }

   
    public static void main(String[] args) {

        transformarT9Texto("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT1\\PD6\\entrada.txt"); 

    }
}
