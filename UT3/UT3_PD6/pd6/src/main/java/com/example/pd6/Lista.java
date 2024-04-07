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
        if (primero == null) {
            return true;
        }
        if (primero.compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        } else {
            Nodo<T> temp = primero;
            while (temp.getSiguiente() != null) {
                if (temp.getSiguiente().compareTo(clave) == 0){
                    temp.setSiguiente(temp.getSiguiente().getSiguiente());
                    return true;
                }
                temp = temp.getSiguiente();
            }
            return false;
        }
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
