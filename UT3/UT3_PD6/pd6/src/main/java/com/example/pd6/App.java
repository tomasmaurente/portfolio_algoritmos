package com.example.pd6;

/*
 * 1.  Descargar el archivo “suc1.txt”, guardarlo en el directorio raíz de su implementación como “sucursales.txt” y 
        ejecutar el programa, emitiendo por consola la cantidad de elementos y la lista de ciudades contenida en la 
        estructura. La cantidad de elementos es: 

        b) 105
 
2.  Eliminar la ciudad “Chicago”- listar nuevamente el conjunto de sucursales. Dada la ciudad ·“Hong Kong”, la 
        que le sigue en la lista es la ciudad .... 
        
        c) Shenzhen 
 
3.  Levantar un segundo archivo, “suc2.txt”. Eliminar las ciudades “Shenzen” y “Tokio”. Se cumple lo siguiente: 
         
        d) Ninguna de las anteriores 
 
4.  Levantar un tercer archivo, “suc3.txt”. Invocar al método “Imprimir(“;_”)”. El resultado de esta operación es: 
        
        ï»¿Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_
 */
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

