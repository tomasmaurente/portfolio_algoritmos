package com.example;

public class Nodo<T> implements INodo<T>{

    private T data;
    private Nodo<T> next = null;
    @SuppressWarnings("rawtypes")
    private Comparable identifier;

    public Nodo( Comparable identifier, T data){
        this.identifier = identifier;
        this.data = data;
    }

    public T getDato(){
        return this.data;
    }
    
    public Nodo<T> getSiguiente(){
        return this.next;
    }
    
    
    public void setSiguiente(Nodo<T> nodo){
        this.next = nodo;
    }
    
    public void imprimir(){
        System.out.println(this.data);
    }

    public String imprimirString(){
        return this.data.toString();
    }

    /**
     * Imprime la etiqueta del nodo
     */
    
    public void imprimirEtiqueta(){
        System.out.println(identifier);
    }

    
    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta(){
        return this.identifier;
    }

//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo<E> unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta){
        return this.identifier.compareTo(etiqueta);
    }
}

