package com.example;

public class Main {
    public static void main(String[] args) {
        ILista lista = new Lista();

        for( int i = 0; i < 10 ; i++){
            Nodo nodo = new Nodo(i,i);
            lista.insertar(nodo);
        }

        System.out.println(lista.imprimir());
        System.out.println(lista.buscar(-1));

        for( int i = -1; i > -11 ; i--){
            Nodo nodo = new Nodo(i,i);
            lista.setPrimero(nodo);
        }

        System.out.println(lista.imprimir(" "));
        System.out.println(lista.buscar(-1).imprimirString());

        for( int i = -10; i < 0 ; i++){
            lista.eliminar(i);
        }

        System.out.println(lista.imprimir(" "));

        for( int i = 10; i < 101 ; i++){
            lista.insertar(i,i);
        }

        System.out.println(lista.imprimir(" | "));
        System.out.println("La cantidad de nodos deberia ser 101 y es: " + lista.cantElementos());

        for( int i = 0; i < 1011 ; i++){
            lista.eliminar(i);
        }

        System.out.println("La lista es vacia?: " + lista.esVacia());
    }
}
