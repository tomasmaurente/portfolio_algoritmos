package com.example;

import java.util.ArrayList;
import com.example.inter.IElementoAB;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    public int obtenerAltura() {

        int alturaIzq = 0;
        int alturaDer = 0;

        if (this.hijoDer == null && this.hijoIzq == null) {
            return 0;
        }
        if (hijoDer != null) {
            alturaDer = hijoDer.obtenerAltura() + 1;
        }
        if (hijoIzq != null) {
            alturaIzq = hijoIzq.obtenerAltura() + 1;
        }

        if (alturaDer < alturaIzq) {
            return alturaIzq;
        } else
            return alturaDer;
    }

    public int obtenerTamanio() {
        if (hijoDer == null && hijoIzq == null) {
            return 1;
        } else if (hijoDer != null && hijoIzq == null) {
            return hijoDer.obtenerTamanio() + 1;
        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerTamanio() + 1;
        } else {
            return hijoIzq.obtenerTamanio() + hijoDer.obtenerTamanio() + 1;
        }
    }

    public Integer obtenerNivel(Comparable unaEtiqueta) {
        if(etiqueta.equals(unaEtiqueta)){
            return 1;
        }
        if (etiqueta.compareTo(unaEtiqueta) < 0){
            if (hijoIzq != null) {
                return hijoIzq.obtenerNivel(unaEtiqueta) + 1;
            } else {
                return null;
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.obtenerNivel(unaEtiqueta) + 1;
            } else {
                return null;
            }
        }
    }

    /**
     * @return recorrida en inorden del Arbol 
     */
    @Override
    public String inOrden() {
        StringBuilder inOrden = new StringBuilder();
        if( hijoIzq != null){
            inOrden.append(hijoIzq.inOrden());
        }
        inOrden.append(this.etiqueta.toString() + "-");
        if( hijoDer != null){
            inOrden.append(hijoDer.inOrden());
        }
        return inOrden.toString();
    }

    @Override
    public String preOrden() {
        StringBuilder preOrden = new StringBuilder();
        preOrden.append(this.etiqueta.toString() + "-");
        
        if( hijoIzq != null){
            preOrden.append(hijoIzq.inOrden());
        }
        
        if( hijoDer != null){
            preOrden.append(hijoDer.inOrden());
        }
        return preOrden.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder postOrden = new StringBuilder();
        
        if( hijoIzq != null){
            postOrden.append(hijoIzq.inOrden());
        }
        
        if( hijoDer != null){
            postOrden.append(hijoDer.inOrden());
        }
        postOrden.append(this.etiqueta.toString() + "-");
        return postOrden.toString();
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta == null) {
            return null;
        }
        if (etiqueta.compareTo(unaEtiqueta) > 0 ) {      // Busco el nodo a eliminar en los mas pequeños
            if (hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;

        } else if (etiqueta.compareTo(unaEtiqueta) < 0 ) {    // Busco el nodo a eliminar en los mas pequeños
            if (hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        
        } else if (hijoDer == null && hijoIzq == null) {         // Una vez que lo encuentro trato el caso de que tenga dos hijos
            return null;
        } else if (hijoDer != null && hijoIzq == null){
            return hijoDer;
        } else if (hijoIzq != null && hijoDer == null){
            return hijoIzq;
        } else {
            TElementoAB<T> nodo = this.calveAnterior(etiqueta);  // Encuentro su hijo con clave anterior
            this.eliminar(nodo.getEtiqueta());                   // Elimino el hijo con clave anterior del arbol, notese que aun sigue existiendo en la variable nodo y que al eliminar la clave anterior el subarbol ya queda ordenado por lo que lo unico que tengo que hacer luego es reasignar los hijos del nuevo nodo
            nodo.setHijoDer(hijoDer);                           
            nodo.setHijoIzq(hijoIzq);                            // Se puede deducir que el nodo de clave anterior no va a tener hijo derecho 
            return nodo;                                         // Devuelvo el nuevo nodo
        }
    }

    public TElementoAB<T> menorClave() {
        if (hijoIzq != null){
            return hijoIzq.menorClave();
        } else {
            return this;
        }
    }

    public TElementoAB<T> mayorClave() {
        if (hijoDer != null){
            return hijoDer.mayorClave();
        } else {
            return this;
        }
    }

    public TElementoAB<T> calveAnterior(Comparable clave) {
        if (clave == null) {
            return null;
        }
        if (etiqueta.compareTo(clave) > 0 ) {      // Busco el nodo a eliminar en los mas pequeños
            if (hijoIzq != null){
                return hijoIzq.calveAnterior(clave);
            }
            return null;

        } else if (etiqueta.compareTo(clave) < 0 ) {    // Busco el nodo a eliminar en los mas pequeños
            if (hijoDer != null){
                return hijoDer.calveAnterior(clave);
            }
            return this;
        
        } else if ( hijoIzq != null){
            TElementoAB<T> nodo = hijoIzq;
            while (nodo.hijoDer != null) {
                nodo = nodo.hijoDer;
            }
            return nodo;
        } 
        return null;
    }

    public TElementoAB<T> calveSiguiente(Comparable clave) {
        if (hijoDer != null){
            TElementoAB<T> nodo = hijoDer;
            while (nodo.hijoIzq != null) {
                nodo = nodo.hijoIzq;
            }
            return nodo;
        }
        return null;
    }

    public int cantNodosNivel(int nivelBuscado, int nivel) {
        if (nivelBuscado == nivel){
            return 1;
        } else {
            int cont = 0;
            if( hijoIzq != null){
                cont += hijoIzq.cantNodosNivel(nivelBuscado, nivel + 1);
            }
            
            if( hijoDer != null){
                cont += hijoDer.cantNodosNivel(nivelBuscado, nivel + 1);
            }

            return cont;
        }
    }

    public void listarHojas(ArrayList<TElementoAB<T>> lista) {
        if (hijoDer == null && hijoIzq == null){
            lista.add(this);
        } else {
            if( hijoIzq != null){
                hijoIzq.listarHojas(lista);
            }
            
            if( hijoDer != null){
                hijoDer.listarHojas(lista);
            }
        }
    }

    public Boolean esDeBusqueda() {
        if (hijoDer == null && hijoIzq == null){
            return true;
        } else {
            Boolean iz = true;
            Boolean der= true;
            if( hijoIzq != null){
                if ( etiqueta.compareTo(hijoIzq.getEtiqueta()) > 0 ){
                    iz = hijoIzq.esDeBusqueda();
                } else {
                    return false;
                }
            }
            
            if( hijoDer != null){
                if ( etiqueta.compareTo(hijoDer.getEtiqueta()) < 0 ){
                    der = hijoDer.esDeBusqueda();
                } else {
                    return false;
                }
            }

            return iz && der;
        }
    }
}
