package com.example.pd6;

import com.example.pd6.interfaces.*;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        unNodo.setSiguiente(primero);
        primero = unNodo;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> temp = primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> temp = primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (primero == null) {
            return null;
        } else {
            Nodo<T> temp = primero;
            while (temp != null) {
                if (temp.compareTo(clave) == 0){
                    return temp;
                }
                temp = temp.getSiguiente();
            }
            return null;
        }
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return true;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp1 = aux;
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        if (primero == null) {
            return null;
        } else {
            Nodo<T> temp = primero;
            while (temp != null) {
                System.out.println(temp.getEtiqueta().toString());
                temp = temp.getSiguiente();
            }
            return null;
        }
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder resultado = new StringBuilder();
        if (primero == null) {
            return null;
        } else {
            Nodo<T> temp = primero;
            while (temp != null) {
                resultado.append(temp.getEtiqueta().toString());
                resultado.append(separador);
                temp = temp.getSiguiente();
            }
            return resultado.toString();
        }
    }

    @Override
    public int cantElementos() {
        int resultado = 0;
        if (primero == null) {
            return resultado;
        } else {
            Nodo<T> temp = primero;
            while (temp != null) {
                resultado++;
                temp = temp.getSiguiente();
            }
            return resultado;
        }
    }

    @Override
    public boolean esVacia() {
        if (primero == null) {
            return true;
        } else { 
            return false;
        }
    }
}
