package com.example;

import java.util.ArrayList;

import com.example.interfaces.IArbolBB;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public int obtenerAltura() {
        if (raiz != null){
            return this.raiz.obtenerAltura();
        } 
        return 0;
        
    }

    @Override
    public int obtenerTamanio() {
        if (raiz == null){
            return 0;
        } else {
            return raiz.obtenerTamanio();
        }
    }

    

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public TElementoAB<T> menorClave() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.menorClave();
        }
    }

    @Override
    public TElementoAB<T> mayorClave() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.mayorClave();
        }
    }

    @Override
    public TElementoAB<T> calveAnterior(Comparable clave) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.calveAnterior(clave);
        }
    }

    @Override
    public Integer cantNodosNivel(int nivel) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.cantNodosNivel(nivel, 1);
        }
    }

    @Override
    public ArrayList<TElementoAB<T>> listarHojas() {
        if (esVacio()) {
            return null;
        } else {
            ArrayList<TElementoAB<T>> array = new ArrayList<TElementoAB<T>>();
            raiz.listarHojas(array);
            return array;
        }
    }

    @Override
    public Boolean esDeBusqueda() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.esDeBusqueda();
        }
    }

   

}
