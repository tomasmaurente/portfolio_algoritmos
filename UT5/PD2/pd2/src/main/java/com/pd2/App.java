package com.pd2;

import java.util.LinkedList;

import com.pd2.trie.TArbolTrie;

/**
 * El codigo no acepta Ñ ni tildes
 * 
 * Responde las siguientes preguntas:
    • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Programa”?
    • ¿Cuántas comparaciones realiza el algoritmo de búsqueda si el argumento es “Proselitismo?
    • ¿Cuántas comparaciones se realizan para insertar la palabra “cazadores”?
    • ¿cuál es la altura del árbol trie resultante?
    • ¿cuál es su tamaño?
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TArbolTrie arbol = new TArbolTrie();

        String[] palabras = new String[12];
        palabras[0] = "Ala, 1, 3, 88";
        palabras[1] = "Alimana, 11, 22";
        palabras[2] = "Alabastro, 4";
        palabras[3] = "Perro, 5, 8";
        palabras[4] = "Pera, 7,12";
        palabras[5] = "Alimento, 9";
        palabras[6] = "Casa, 11,13";
        palabras[7] = "Casada, 1";
        palabras[8] = "Cazar, 33";
        palabras[9] = "Programa, 22, 67";
        palabras[10] = "Programacion, 15";
        palabras[11] = "Programar, 15,16";

        for( String p : palabras){
            String[] cont = p.split(",");
            Integer[] paginas = new Integer[cont.length -1];
            for ( int i = 0; i < cont.length - 1; i++){
                paginas[i] = Integer.parseInt(cont[i + 1].trim());
            }
            arbol.insertar(cont[0].trim(), paginas);
        }

        arbol.imprimir();

        System.out.println(arbol.buscar("Programa"));
        System.out.println(arbol.buscar("Proselitismo"));
        System.out.println(arbol.insertarComparaciones("cazadores"));

        System.out.println("Altura arbol: " + arbol.getAltura());
        System.out.println("Tamaño arbol: " + arbol.getTamano());

        LinkedList<Integer> paginas = arbol.buscarPaginas("Ala");
        
        for (Integer i : paginas){
            System.out.println(i);
        }
    }
}
