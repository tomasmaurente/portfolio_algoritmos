package com.example;

import java.io.*;
import java.util.Scanner;

public class pd6 {
    
    public static String[] fileContent;
    public static int entradaStdIn;

    public static void imprimirTablero(int largo, int ancho) {
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho - 1; j++) {
                System.out.print("X");
            }
            System.out.println("X");
        }
    }

    public static void construirTexto(String nombre, String floatNum, String intNum){
        float floatNumConverted = 0;
        float intNumConverted = 0;
        float divicionEntera = 0;
        float resto = 0;
        float suma = 0;
        
        try{
            floatNumConverted = Float.parseFloat(floatNum);
            intNumConverted = Float.parseFloat(intNum);
            divicionEntera = floatNumConverted / intNumConverted;
            resto = floatNumConverted % intNumConverted;
            suma = intNumConverted + floatNumConverted;
        } catch (Exception e) {
            floatNumConverted = 1;
            intNumConverted = 1;
            System.out.println("Los numeros no se pudieron recibir exitosamente, se setearon en 1 para evitar futuros problemas");
            e.printStackTrace();
        }
        System.out.println("El entero leído es: " + intNumConverted);
        System.out.println("El número de punto flotante es: " + floatNum);
        System.out.println("La cadena leída es " + nombre);
        System.out.println("¡Hola " + nombre+ "! La suma de " + intNum + " y " + floatNum + " es " + suma);
        System.out.println("La división entera de " + intNum + " y " + floatNum + " es " + divicionEntera + " y su resto es " + resto);
    }

    public static void leerEntradaArchivo(String rutaArchivo){
        FileReader fr;
        int rowCounter = 0;
        try {
            fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                rowCounter++;
                lineaActual = br.readLine();
            }

            fileContent = new String[rowCounter];
            rowCounter = 0;

            fr = new FileReader(rutaArchivo);
            br = new BufferedReader(fr);
            lineaActual = br.readLine();
            while (lineaActual != null) {
                fileContent[rowCounter] = lineaActual;
                rowCounter++;
                lineaActual = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + rutaArchivo);
            e.printStackTrace();
            fileContent = new String[0];
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + rutaArchivo);
            e.printStackTrace();
            fileContent = new String[0];
        }
    }

    public static void leerEntradaStdin(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        String input = scanner.next();
        try {
            entradaStdIn = Integer.parseInt(input);
            System.out.println("Número ingresado: " + entradaStdIn);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se esperaba un número entero.");
        }
    }

    public static void calcularArea() {
        leerEntradaStdin();
        double area = Math.PI * entradaStdIn * entradaStdIn;
        System.out.println("El area del circulo es: " + area);
    }

    public static void calcularPerimetro() {
        leerEntradaStdin();
        double perimetro = 2 * Math.PI * entradaStdIn;
        System.out.println("El perimtro del circulo es: " + perimetro);
    }




    public static void main(String[] args) {
        imprimirTablero(7, 7);

        leerEntradaArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT1\\PD6\\entrada.txt");  // C:\Users\Tomas\Desktop\Algoritmos\portfolio_algoritmos\UT1\PD6\entrada.txt
        
        if (pd6.fileContent.length > 1)
        construirTexto(pd6.fileContent[2], pd6.fileContent[1], pd6.fileContent[0]);
    
        calcularArea();
        calcularPerimetro();
        
    }
}
