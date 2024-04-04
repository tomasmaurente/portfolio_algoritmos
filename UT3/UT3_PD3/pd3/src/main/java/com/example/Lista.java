package com.example;


public class Lista<T> implements ILista<T> {

    private Nodo<T> first = null;
    private Nodo<T> last = null;

    public Lista(){}

      /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo a agregar
     */


    @Override
    public void insertar (Comparable etiqueta, T dato ){
        Nodo<T> nodo = new Nodo<T>(etiqueta,dato);
        if (last == null){
            first = nodo;
            last = nodo;
        } else {
            last.setSiguiente(nodo);
            last = nodo;
        }
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (last == null){
            first = nodo;
            last = nodo;
        } else {
            last.setSiguiente(nodo);
            last = nodo;
        }
    }
    
    /**
     * 
     * 
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public Nodo<T> buscar(Comparable clave){
        Nodo<T> nodoAux = first;
        while (nodoAux != null) {
            if (nodoAux.compareTo(clave) == 0) return nodoAux;
            nodoAux = nodoAux.getSiguiente();
        }
        return null;
    }

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave){
        Nodo nodoAux = first;
        if (nodoAux == null) return true;
        if(nodoAux.compareTo(clave) == 0){
            first = first.getSiguiente();
            return true;
        }
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().compareTo(clave) == 0){
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                return true;
            } 
            nodoAux = nodoAux.getSiguiente();
        }
        return false;
    }

    /**
     * Metodo encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     * @return 
     */
    public String imprimir(){
        StringBuilder result = new StringBuilder();
        Nodo nodoAux = first;
        while (nodoAux != null) {
            result.append(nodoAux.imprimirString()); 
            nodoAux = nodoAux.getSiguiente();
        }
        return result.toString();
    }

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * par�metro.
     *
     * @param separador Separa las claves
     * @return
     */
    public String imprimir(String separador){
        StringBuilder result = new StringBuilder();
        INodo<T> nodoAux = first;
        while (nodoAux != null) {
            result.append(nodoAux.imprimirString()); 
            result.append(separador); 
            nodoAux = nodoAux.getSiguiente();
        }
        return result.toString();

    }

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vac�a, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos(){
        int result = 0;
        Nodo nodoAux = first;
        while (nodoAux != null) {
            result++;
            nodoAux = nodoAux.getSiguiente();
        }
        return result;
    }

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    public boolean esVacia(){
        return first == null;
    }
    
    public void setPrimero( Nodo<T> unNodo){
        if (first != null){
            unNodo.setSiguiente(first);
            first = unNodo;
        } else {
            first = unNodo;
        }
    }

    
}
