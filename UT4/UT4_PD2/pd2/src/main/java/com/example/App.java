package com.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        /*
         * Parte 1
         */

        ManejadorArchivosGenerico lector = new ManejadorArchivosGenerico();
        String[] claves = lector.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT4\\UT4_PD2\\pd2\\src\\main\\java\\com\\example\\claves\\claves1.txt");

        TArbolBB<TElementoAB> arbol = new TArbolBB<TElementoAB>();
        ArrayList<Comparable> etiquetas = new ArrayList<Comparable>(12);
        Comparable etiqueta = null;
        for (String clave : claves) {
            etiqueta = Integer.parseInt(clave);
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<String>(etiqueta, clave);
            arbol.insertar(e);
        }

        Boolean nodoExiste = true;

        for (Comparable e : etiquetas) {
            if (arbol.buscar(e) == null) {
                System.out.println("El nodo de clave: " + e + " no se encontro en el arbol");
            }
        }
        System.out.println(arbol.preOrden());

        /*
         * Parte 2
         */

        lector = new ManejadorArchivosGenerico();
        claves = lector.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT4\\UT4_PD2\\pd2\\src\\main\\java\\com\\example\\claves\\clavesPrueba.txt");

        arbol = new TArbolBB<TElementoAB>();
        etiquetas = new ArrayList<Comparable>(12);
        etiqueta = null;
        for (String clave : claves) {
            etiqueta = Integer.parseInt(clave);
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<String>(etiqueta, clave);
            arbol.insertar(e);
        }
        System.out.println(arbol.preOrden());
        System.out.println(arbol.inOrden());
        System.out.println(arbol.postOrden());

        /*
         * Parte 3
         */

        lector = new ManejadorArchivosGenerico();
        claves = lector.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT4\\UT4_PD2\\pd2\\src\\main\\java\\com\\example\\claves\\claves1.txt");

        arbol = new TArbolBB<TElementoAB>();
        etiquetas = new ArrayList<Comparable>(12);
        etiqueta = null;
        for (String clave : claves) {
            etiqueta = Integer.parseInt(clave);
            etiquetas.add(etiqueta);
            TElementoAB e = new TElementoAB<String>(etiqueta, clave);
            arbol.insertar(e);
        }

        System.out.println("El nodo de clave: " + 10635 + " " + arbol.buscar((Comparable)10635));
        System.out.println("El nodo de clave: " + 4567 + " " + arbol.buscar((Comparable)4567));
        System.out.println("El nodo de clave: " + 12 + " " + arbol.buscar((Comparable)12));
        System.out.println("El nodo de clave: " + 8978 + " " + arbol.buscar((Comparable)8978));
        
    }
}
