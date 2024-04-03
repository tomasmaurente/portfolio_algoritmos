package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static class PalabrasLargas extends ContadorPalabras {
        public static int contador = 0;

        public void largasPalabras(String string, int x) {
            if (string.length() > x) {
                contador++;
            }
        }
    }

    public static class PalabrasLector extends ContadorPalabras {

        public void lectorPalabras(String string) {
            String[] palabras = {};
            for (String palabra : palabras) {
                if (palabra.length() > 7) {
                    PalabrasLargas pl = new PalabrasLargas();
                    pl.largasPalabras(palabra, 7);
                }
            }
        }
    }

    public static class ContadorPalabras {

        public int contador = 0;

        public boolean IsLetter(char a) {
            return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
        }

        public void contarPalabras(String rutaArchivo) {
            boolean isWord = false;
            int palabras = 0;
            try {
                BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));
                String linea = bf.readLine();

                int contadorLineas = 0;
                while (linea != null) {
                    contadorLineas++;
                    char[] letrasLinea = linea.toCharArray();
                    String palabra = "";
                    char letra;
                    for (int i = 0; i < letrasLinea.length - 1; i++) {
                        letra = letrasLinea[i];
                        palabra += letra;
                        if (IsLetter(letra)) {
                            isWord = true;
                        } else {
                            if (letra == '\n') {
                                PalabrasLargas pl = new PalabrasLargas();
                                pl.largasPalabras(palabra.trim(), 7);
                                System.err.println(palabra);
                                palabras++;
                                isWord = false;
                                palabra = "";
                            }
                            if (isWord) {
                                PalabrasLargas pl = new PalabrasLargas();
                                pl.largasPalabras(palabra.trim(), 7);
                                System.err.println(palabra);
                                palabras++;
                                isWord = false;
                                palabra = "";
                            }
                        }
                    }
                    if (isWord) {
                        PalabrasLargas pl = new PalabrasLargas();
                        pl.largasPalabras(palabra.trim(), 7);
                        System.err.println(palabra);
                        palabras++;
                        isWord = false;
                        palabra = "";
                    }
                    linea = bf.readLine();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Error de formato de archivo");
            }
            this.contador = palabras;
        }

        public String[] contarLineas(String rutaArchivo) {
            boolean isWord = false;
            int palabras = 0;
            try {
                BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));
                String linea = bf.readLine();

                int contadorLineas = 0;
                while (linea != null) {
                    contadorLineas++;
                    linea = bf.readLine();
                }

                String[] lineas = new String[contadorLineas];

                bf = new BufferedReader(new FileReader(rutaArchivo));
                linea = bf.readLine();
                contadorLineas = 0;

                while (linea != null) {
                    lineas[contadorLineas] = linea;
                    contadorLineas++;
                    linea = bf.readLine();
                }

                return lineas;

            } catch (IOException e) {
                System.err.println(e.getMessage());
                return new String[0];
            } catch (NumberFormatException e) {
                System.err.println("Error de formato de archivo");
                return new String[0];
            }
        }
    }

    public static void main(String[] args) {
        ContadorPalabras contador = new ContadorPalabras();
        contador.contarPalabras(
                "C:\\Users\\dutra\\OneDrive\\Documentos\\Algoritmos\\ejercicios\\ut1_ta3_ej1\\src\\main\\java\\com\\ut1_ta3_ej1\\UT1_TA3_ARCHIVO_EJEMPLO.txt");
        System.out.println(contador.contador);
        System.out.println(PalabrasLargas.contador);

        String[] lineas = contador.contarLineas(
                "C:\\Users\\dutra\\OneDrive\\Documentos\\Algoritmos\\ejercicios\\ut1_ta3_ej1\\src\\main\\java\\com\\ut1_ta3_ej1\\UT1_TA3_ARCHIVO_EJEMPLO.txt");
        System.out.println(lineas.length);

    }
}
