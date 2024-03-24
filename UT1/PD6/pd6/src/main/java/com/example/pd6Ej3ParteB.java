package com.example;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class pd6Ej3ParteB {

    private static final Map<String, Character> t9ToLetterMap = new HashMap<>();

    public static void transformarTextoT9(String rutaArchivo) {
        try (
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT1\\PD6\\salidaInversa.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.toUpperCase(); // Convertir a mayúsculas para manejar todos los casos
                StringBuilder resultado = new StringBuilder();
                for (String c : linea.split(" ")) {
                    resultado.append(obtenerLetraT9(c));
                }
                bw.write(resultado + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    static {
        t9ToLetterMap.put("2", 'A');
        t9ToLetterMap.put("22", 'B');
        t9ToLetterMap.put("222", 'C');
        t9ToLetterMap.put("3", 'D');
        t9ToLetterMap.put("33", 'E');
        t9ToLetterMap.put("333", 'F');
        t9ToLetterMap.put("4", 'G');
        t9ToLetterMap.put("44", 'H');
        t9ToLetterMap.put("444", 'I');
        t9ToLetterMap.put("5", 'J');
        t9ToLetterMap.put("55", 'K');
        t9ToLetterMap.put("555", 'L');
        t9ToLetterMap.put("6", 'M');
        t9ToLetterMap.put("66", 'N');
        t9ToLetterMap.put("666", 'O');
        t9ToLetterMap.put("7", 'P');
        t9ToLetterMap.put("77", 'Q');
        t9ToLetterMap.put("777", 'R');
        t9ToLetterMap.put("7777", 'S');
        t9ToLetterMap.put("8", 'T');
        t9ToLetterMap.put("88", 'U');
        t9ToLetterMap.put("888", 'V');
        t9ToLetterMap.put("9", 'W');
        t9ToLetterMap.put("99", 'X');
        t9ToLetterMap.put("999", 'Y');
        t9ToLetterMap.put("9999", 'Z');
        t9ToLetterMap.put("0", ' ');
        t9ToLetterMap.put("1", '.');
    }

    public static char obtenerLetraT9(String numeroT9) {
        return t9ToLetterMap.getOrDefault(numeroT9, ' '); // Devuelve ' ' si no encuentra ninguna letra asociada
    }


   
    public static void main(String[] args) {

        transformarTextoT9("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT1\\PD6\\salida.txt"); 

    }
}
