package com.example.trie;

import java.util.*;

public class TNodoTrie implements INodoTrie {
    private final static int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> hojasDelLibro;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        hojasDelLibro = new LinkedList<Integer>();
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        unaPalabra = unaPalabra.toLowerCase();
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = getIndice(unaPalabra.charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    public int insertarComparaciones(String unaPalabra) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        unaPalabra = unaPalabra.toLowerCase();
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = getIndice(unaPalabra.charAt(c));
            comparaciones++;
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        return comparaciones;
    }
    
    public void insertar(String unaPalabra, Integer[] hojas) {
        TNodoTrie nodo = this;
        unaPalabra = unaPalabra.toLowerCase();
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = getIndice(unaPalabra.charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        for (int i : hojas) {
            nodo.hojasDelLibro.add(i);
        }
    }

    public int getAltura(TNodoTrie nodo){
        int altura = 0;
        Boolean empty = true;

        for (TNodoTrie tNodoTrie : nodo.hijos) {
            if(tNodoTrie != null){
                altura = Math.max(altura, getAltura(tNodoTrie)) + 1;
                empty = false;
            }
        }

        if (empty){
            return 0;
        }

        return altura;
    }


    public int getTamaño(TNodoTrie nodo){
        int tamano = 0;
        Boolean empty = true;

        for (TNodoTrie tNodoTrie : nodo.hijos) {
            if(tNodoTrie != null){
                tamano += getTamaño(tNodoTrie);
                empty = false;
            }
        }

        if (empty){
            return 1;
        }

        return tamano + 1;
    }



    private int getIndice(char c) {
        return  c - 'a';
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndice(s.charAt(c));
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
    /**
     * Busca una palabra en el trie y devuelve la cantidad de comparaciones realizadas durante la búsqueda.
     *
     * @param s La palabra a buscar dentro del trie.
     * @return El número de comparaciones realizadas para determinar si la palabra está o no en el trie.
     */
    @Override
    public int buscar(String s) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        s = s.toLowerCase();
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndice(s.charAt(c));
            nodo = nodo.hijos[indice];
            comparaciones++;
            if (nodo == null) {
                return comparaciones;
            }
        }
        return nodo.esPalabra ? comparaciones : -1;
    }

    /**
     * Busca una palabra en el trie y devuelve la cantidad de comparaciones realizadas durante la búsqueda.
     *
     * @param s La palabra a buscar dentro del trie.
     * @return El número de comparaciones realizadas para determinar si la palabra está o no en el trie.
     */
    public LinkedList<Integer> buscarPaginas(String s) {
        TNodoTrie nodo = this;
        s = s.toLowerCase();
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndice(s.charAt(c));
            nodo = nodo.hijos[indice];
            if (nodo == null) {
                return new LinkedList<Integer>();
            }
        }
        return nodo.esPalabra ? nodo.hojasDelLibro : new LinkedList<Integer>();
    }

    

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), palabras, nodo.hijos[c]);
                }
            }
        }
    }

    /**
     * Genera una lista de todas las palabras que contienen el prefijo dado.
     * Las palabras encontradas se agregan a la lista 'palabras'.
     *
     * @param prefijo El prefijo que se utilizará para buscar palabras en el trie.
     * @param palabras Lista de strings donde se almacenarán las palabras encontradas que coinciden con el prefijo dado.
     */
    @Override
    public void predecir(String prefijo, List<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, (LinkedList<String>) palabras, nodo);
        }
    }
}
