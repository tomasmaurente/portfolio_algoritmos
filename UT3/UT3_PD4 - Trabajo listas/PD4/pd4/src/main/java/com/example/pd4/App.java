package com.example.pd4;

public class App {
    public static void main(String[] args) {
        Almacen almacen = new Almacen("Lo de pepe", "a la vuelta de tu casa", "099");

        /*
         * Ejercicio #1
         * Compra de más unidades de un cierto producto o Incorporación de uno nuevo.
         * ¿Cuál es el valor económico
         * agregado al stock? Dado un archivo de entrada (“altas.txt”) actualizar el
         * almacén en forma correspondiente e
         * indicar el monto total en que se ha incrementado el valor del stock (dinero
         * gastado en comprar estos productos). El
         * archivo “altas.txt” tiene la siguiente estructura (1 producto por línea,
         * campos separados por comas)
         * 
         */

        String[] data = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD4\\PD4\\pd4\\src\\main\\java\\com\\example\\pd4\\files\\archivos almacen\\altas.txt");

        Integer price;
        Integer stock;
        Comparable etiqueta;
        Producto nuevProducto;
        for (String datosProducto : data) {
            String[] datos = datosProducto.split(",");
            etiqueta = datos[0];

            try {
                price = Integer.parseInt(datos[2]);
                stock = Integer.parseInt(datos[3]);
                nuevProducto = new Producto(etiqueta, datos[1], price, stock);
            } catch (Exception e) {
                price = 0;
                stock = 0;
                nuevProducto = new Producto(etiqueta, datos[1], price, stock);
                System.out.println("Hubo un problema con el producto: " + nuevProducto.toString());
            }

            almacen.insertarProducto(nuevProducto);
        }

        System.out.println("El valor del almacen es de: " + almacen.calcularValorAlmacen());

        data = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD4\\PD4\\pd4\\src\\main\\java\\com\\example\\pd4\\files\\archivos almacen\\elim.txt");

        for (String datosProducto : data) {
            Comparable distintivo = datosProducto;
            almacen.eliminar(distintivo);
        }

        System.out.println("El valor del almacen luego de eliminar productos es de: " + almacen.calcularValorAlmacen());

        data = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD4\\PD4\\pd4\\src\\main\\java\\com\\example\\pd4\\files\\archivos almacen\\ventas.txt");

        for (String datosProducto : data) {
            String[] datos = datosProducto.split(",");
            etiqueta = datos[0];

            try {
                stock = Integer.parseInt(datos[1]);
            } catch (Exception e) {
                stock = 0;
                System.out.println("Hubo un problema con el producto: " + etiqueta.toString());
            }

            almacen.restarStock(etiqueta, stock);
        }

        System.out.println("El nuevo valor del almacen luego de vender productos es de: " + almacen.calcularValorAlmacen());






        /*


         PRUEBAS


         * String[] data = ManejadorArchivosGenerico.leerArchivo(
         * "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD4\\PD4\\pd4\\src\\main\\java\\com\\example\\pd4\\files\\archivos prueba\\altasPrueba.txt"
         * );
         * 
         * for (String datosProducto : data ) {
         * String[] datos = datosProducto.split(",");
         * Comparable etiqueta = datos[0];
         * Integer price = Integer.parseInt(datos[2]);
         * Integer stock = Integer.parseInt(datos[3]);
         * Producto nuevProducto = new Producto(etiqueta,datos[1],price,stock);
         * almacen.insertarProducto(nuevProducto);
         * }
         * 
         * System.out.println(almacen.imprimirSeparador("|"));
         * 
         * almacen.listarOrdenadoPorNombre();
         * 
         * //System.out.println(almacen.imprimirSeparador("|"));
         * 
         * Comparable e = "1000088";
         * //System.out.println(almacen.buscarPorCodigo(e));
         * 
         * 
         * //System.out.println("La cantidad de productos es: " +
         * almacen.cantidadProductos());
         * 
         * //System.out.println("La cantidad de productos eliminados deberian ser 2: " +
         * almacen.restarStock(e, 10));
         * //System.out.println("La cantidad de productos es: " +
         * almacen.cantidadProductos());
         * 
         * 
         * for (String datosProducto : data ) {
         * String[] datos = datosProducto.split(",");
         * Comparable etiqueta = datos[0];
         * almacen.eliminar(etiqueta);
         * }
         * 
         * //System.out.println("chau productos");
         * 
         * //almacen.imprimirProductos();
         */

    }
}
