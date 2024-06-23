package pd7;

import pd7.grafoDirigido.TGrafoDirigido;
import pd7.grafoDirigido.UtilGrafos;

public class App 
{
    public static void main( String[] args )
    {
        TGrafoDirigido grafo = (TGrafoDirigido) UtilGrafos.cargarGrafo(
            "UT7\\pd7\\src\\main\\java\\pd7\\utils\\tareas.txt",
            "UT7\\pd7\\src\\main\\java\\pd7\\utils\\precedencias.txt",
            false,
            TGrafoDirigido.class);

        TGrafoDirigido grafoConCiclos = (TGrafoDirigido) UtilGrafos.cargarGrafo(
        "UT7\\pd7\\src\\main\\java\\pd7\\utils\\tareas.txt",
        "UT7\\pd7\\src\\main\\java\\pd7\\utils\\precedenciasConCiclos.txt",
        false,
        TGrafoDirigido.class);

        System.out.println("El grafo sin ciclos tiene ciclos: " + grafo.tieneCiclos());
        System.out.println("El grafo con ciclos tiene ciclos: " + grafoConCiclos.tieneCiclos());
        

    }
}
