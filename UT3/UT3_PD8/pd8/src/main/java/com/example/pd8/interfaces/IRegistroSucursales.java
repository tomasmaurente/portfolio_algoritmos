package com.example.pd8.interfaces;

import com.example.pd8.Sucursal;

public interface IRegistroSucursales {

    /**
     * Incorporar un nuevo producto al supermercado.
     * En caso de que ya exista la etiqueta se entiende que es el mismo producto y se sumara el stock 
     *
     * @param unProducto
     */
    public void insertarSucursal(Sucursal unaSucursal);

    /**
     * Eliminar productos que ya no se venden (por no ser comercializados m�s).
     *
     * @param clave
     * @return
     */
    public boolean eliminarSucursal(Comparable ciudad);

    /**
     * Imprime la lista de productos
     *
     * @return
     */
    public String imprimirSucursales();

    /**
     * Dado un separador ej.:",", ";", imprime los productos separados por tal
     * caracter
     *
     * @param separador
     * @return
     */
    public String imprimirSucursalSeparador(String separador);


    /**
     * Dado un código de producto, indicar las existencias del mismo en el
     * almac�n.
     *
     * @param clave
     * @return 
     */
    public Sucursal buscarPorCodigo(Comparable clave);

    /**
     * Retorna el tama�o del almacen: cantidad de productos. No es lo mismo que
     * el total de stock, sino que ser�a en definitiva el tama�o de la lista.
     *
     * @return
     */
    public int cantidadSucursales();

    /**
     * Responde a la pregunta de si la lista es vacia o no
     *
     * @return Boolean
     */
    public Boolean haySucursales();

}
