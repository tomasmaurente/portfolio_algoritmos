package com.example.pd6;

import com.example.pd6.interfaces.IRegistroSucursales;

public class RegistroSucursales implements IRegistroSucursales {

    private Lista<Sucursal> listaSucursales = new Lista<Sucursal>();

    public RegistroSucursales() {}

    @Override
    public void insertarSucursal(Sucursal unaSucursal) {
        Nodo<Sucursal> sucursal = listaSucursales.buscar(unaSucursal.getSucursal());
        if (sucursal == null){
            listaSucursales.insertar(unaSucursal.getSucursal(), unaSucursal);
        } else {
            System.out.println("Ya existe una sucursal en la ciudad de " + sucursal.getEtiqueta().toString());
        }
    }

    @Override
    public boolean eliminarSucursal(Comparable ciudad) {
        return listaSucursales.eliminar(ciudad);
    }

    @Override
    public String imprimirSucursales() {
        return listaSucursales.imprimir();
    }

    @Override
    public String imprimirSucursalSeparador(String separador) {
        return listaSucursales.imprimir(separador);
    }

    @Override
    public int cantidadSucursales() {
        return listaSucursales.cantElementos();
    }

    @Override
    public Sucursal buscarPorCodigo(Comparable clave) {
        Nodo<Sucursal> sucursal = listaSucursales.buscar(clave);
        if (sucursal != null){
            return sucursal.getDato();
        } 
        return null;
    }

    @Override
    public Boolean haySucursales() {
        return listaSucursales.esVacia();
    }
}
