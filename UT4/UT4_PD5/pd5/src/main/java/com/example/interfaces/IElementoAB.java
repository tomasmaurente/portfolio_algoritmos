package com.example.interfaces;

import java.util.ArrayList;

import com.example.TElementoAB;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

 

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(TElementoAB<T> elemento);

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();
	
	/**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     * @return 
     */
    public TElementoAB eliminar(Comparable unaEtiqueta);

    /**
     * Devuelve la altura del arbol.
     * @return altura del arbol
     */
    public int obtenerAltura();

    /**
     * Devuelve el nivel en el que se encuentra un nodo.
     * @return nivel del nodo en el arbol, null si el nodo no existe
     */
    public Integer obtenerNivel(Comparable unaEtiqueta);

    /**
     * Busca un elemento de menor clave dentro del árbol.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> menorClave();

    /**
     * Busca un elemento de mayor clave dentro del árbol.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> mayorClave();

    /**
     * Busca el elemento de clave anterior al solicitado.
     * @param clave clave .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> calveAnterior(Comparable clave);

    /**
     * Busca el elemento de clave siguiente al solicitado.
     * @param clave clave .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> calveSiguiente(Comparable clave);

    /**
     * Cuenta la cantidad de nodos en un mismo nivel.
     * .
     * @return Cantidad de nodos de un nivel pasado por paramentro.
     */
    public int cantNodosNivel(int nivelBuscado, int nivel);

    /**
     * Cuenta la cantidad de nodos en un mismo nivel.
     * .
     * @return una lista con todas las hojas del arbol.
     */
    public void listarHojas(ArrayList<TElementoAB<T>> lista);

    /**
     * verifica que el arbol sea de busqueda.
     * 
     * @return Cantidad de nodos de un nivel pasado por paramentro.
     */
    public Boolean esDeBusqueda();

}
