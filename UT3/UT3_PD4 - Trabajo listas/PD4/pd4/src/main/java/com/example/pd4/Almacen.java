package com.example.pd4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.pd4.interfaces.*;

public class Almacen implements IAlmacen {

    private String nombre;
    private String telefono;
    private String direccion;
    private Lista<Producto> listaProductos = new Lista<Producto>();

    public Almacen(
            String nombre,
            String direccion,
            String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public BigDecimal  calcularValorAlmacen(){
        BigDecimal  contador = BigDecimal.ZERO;
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
        String[] claves = listaProductos.imprimir(",").split(",");
        for (String clave : claves) {
            lista.add(listaProductos.buscar(clave).getDato());
        }

        for (Producto producto : lista) {
            BigDecimal precioProducto = BigDecimal.valueOf(producto.getPrecio());
            BigDecimal stockProducto = BigDecimal.valueOf(producto.getStock());
            contador = contador.add(precioProducto.multiply(stockProducto));
        }

        return contador;
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista getListaProductos() {
        Lista<Producto> nuevaLista = this.listaProductos;
        return nuevaLista;
    }


    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<Producto> producto = listaProductos.buscar(unProducto.getEtiqueta());
        if (producto == null){
            listaProductos.insertar(unProducto.getEtiqueta(), unProducto);
        } else {
            producto.getDato().setStock(
                producto.getDato().getStock() + unProducto.getStock()
            );
        }
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto producto = listaProductos.buscar(clave).getDato();
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto producto = listaProductos.buscar(clave).getDato();
        if (producto != null) {
            if ((producto.getStock() - cantidad) >= 0) {
                producto.setStock(producto.getStock() - cantidad);
                return cantidad;
            } else {
                Integer cantidadVendida = producto.getStock();
                producto.setStock(0);
                return cantidadVendida;
            }
        }
        return 0;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        if (listaProductos.buscar(clave) != null){
            return listaProductos.buscar(clave).getDato();
        } else {
            return null;
        }
    }

    @Override
    public void listarOrdenadoPorNombre() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
        String[] claves = listaProductos.imprimir(",").split(",");
        for (String clave : claves) {
            lista.add(listaProductos.buscar(clave).getDato());
        }

        // Ordenar la lista por nombre
        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        Lista<Producto> listaOrdenadaPorNombre = new Lista<Producto>();
        for( Producto producto : lista){
            listaOrdenadaPorNombre.insertar(producto.getEtiqueta(), producto);
        }

        listaProductos = listaOrdenadaPorNombre;
    }

    /*
     * ???
     */
    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorDescripcion'");
    }

    @Override
    public int cantidadProductos() {
        int contador = 0;
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
        String[] claves = listaProductos.imprimir(",").split(",");
        for (String clave : claves) {
            lista.add(listaProductos.buscar(clave).getDato());
        }

        for( Producto producto: lista){
            contador += producto.getStock();
        }

        return contador;
    }
}
