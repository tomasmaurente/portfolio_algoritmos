package com.example.pd8;

public class App {
    public static void main(String[] args) {

        RegistroSucursales registroSucursales;
        String[] data;
        Comparable ciudad;
        Sucursal sucursal;
        Comparable ciudadEliminar;

        registroSucursales = new RegistroSucursales();

        data = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD6\\pd6\\src\\main\\java\\com\\example\\pd6\\files\\suc1.txt");

        for (String dato : data) {
            ciudad = dato;
            sucursal = new Sucursal(ciudad);
            registroSucursales.insertarSucursal(sucursal);
        }

        System.out.println("Las sucursales actuales son: " + registroSucursales.imprimirSucursalSeparador(" | "));
        System.out.println("La cantidad de sucursales actuales son: " + registroSucursales.cantidadSucursales());

        ciudadEliminar = "Chicago";
        registroSucursales.eliminarSucursal(ciudadEliminar);
        System.out.println("Las sucursales actuales son: " + registroSucursales.imprimirSucursalSeparador(" | "));
        System.out.println("La cantidad de sucursales actuales son: " + registroSucursales.cantidadSucursales());


        System.out.println();
        System.out.println();
        System.out.println();


        registroSucursales = new RegistroSucursales();

        data = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD6\\pd6\\src\\main\\java\\com\\example\\pd6\\files\\suc2.txt");

        for (String dato : data) {
            ciudad = dato;
            sucursal = new Sucursal(ciudad);
            registroSucursales.insertarSucursal(sucursal);
        }

        System.out.println("Las sucursales actuales son: " + registroSucursales.imprimirSucursalSeparador(" | "));
        System.out.println("La cantidad de sucursales actuales son: " + registroSucursales.cantidadSucursales());

        ciudadEliminar = "Shenzen";
        registroSucursales.eliminarSucursal(ciudadEliminar);
        ciudadEliminar = "Tokio";
        System.out.println(registroSucursales.eliminarSucursal(ciudadEliminar));

        System.out.println("Las sucursales actuales son: " + registroSucursales.imprimirSucursalSeparador(" | "));
        System.out.println("La cantidad de sucursales actuales son: " + registroSucursales.cantidadSucursales());


        System.out.println();
        System.out.println();
        System.out.println();


        registroSucursales = new RegistroSucursales();

        data = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\UT3\\UT3_PD6\\pd6\\src\\main\\java\\com\\example\\pd6\\files\\suc3.txt");

        for (String dato : data) {
            ciudad = dato;
            sucursal = new Sucursal(ciudad);
            registroSucursales.insertarSucursal(sucursal);
        }

        System.out.println("Las sucursales actuales son: " + registroSucursales.imprimirSucursalSeparador(";_"));

        System.out.println();
        System.out.println();
        System.out.println();

    }
}


