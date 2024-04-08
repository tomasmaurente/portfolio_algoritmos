package com.example.pd8;

import java.util.ArrayList;
import com.example.pd8.interfaces.IRegistroSucursales;

public class RegistroSucursales implements IRegistroSucursales {

    private ArrayList<Sucursal> listaSucursales = new ArrayList<Sucursal>();

    public RegistroSucursales() {}

    @Override
    public void insertarSucursal(Sucursal unaSucursal) {
        for (Sucursal s : listaSucursales){
            if ( s.getSucursal().equals(unaSucursal.getSucursal()) ){
                System.out.println("Ya existe una sucursal en la ciudad de " + s.getSucursal());
            }
        }
        listaSucursales.add(unaSucursal);
    }

    @Override
    public boolean eliminarSucursal(Comparable ciudad) {
        for (Sucursal s : listaSucursales){
            if ( s.getSucursal().equals(ciudad.toString()) ){
                listaSucursales.remove(s);
                return true;
            }
        }
        return false;
    }

    @Override
    public String imprimirSucursales() {
        return listaSucursales.toString();
    }

    @Override
    public String imprimirSucursalSeparador(String separador) {
        StringBuilder resultado = new StringBuilder();
        for (Sucursal s : listaSucursales){
            resultado.append(s.toString() + separador);
        }
        return resultado.toString();
    }

    @Override
    public int cantidadSucursales() {
        return listaSucursales.size();
    }

    @Override
    public Sucursal buscarPorCodigo(Comparable clave) {
        for (Sucursal s : listaSucursales){
            if ( s.getSucursal().equals(clave.toString()) ){
                return s;
            }
        }
        return null;
    }

    @Override
    public Boolean haySucursales() {
        return listaSucursales.isEmpty();
    }
}
