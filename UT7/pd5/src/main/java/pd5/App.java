package pd5;

import pd5.grafoDirigido.TGrafoDirigido;
import pd5.grafoDirigido.UtilGrafos;

public class App 
{
    public static void main( String[] args )
    {
        pd5.grafoDirigido.TGrafoDirigido grafo = (TGrafoDirigido) UtilGrafos.cargarGrafo(
            "pd5\\src\\main\\java\\pd5\\utils\\tareas.txt",
            "pd5\\\\src\\main\\java\\pd5\\utils\\precedencias.txt",
            false,
            TGrafoDirigido.class);

        TGrafoDirigido grafoConCiclos = (TGrafoDirigido) UtilGrafos.cargarGrafo(
        "pd5\\\\src\\main\\java\\pd5\\utils\\tareas.txt",
        "pd5\\\\src\\main\\java\\pd5\\utils\\precedenciasConCiclos.txt",
        false,
        TGrafoDirigido.class);

        System.out.println("El grafo sin ciclos tiene ciclos: " + grafo.tieneCiclos());
        System.out.println("El grafo con ciclos tiene ciclos: " + grafoConCiclos.tieneCiclos());

        System.out.println("Orden topologico");
        for (String string : grafo.ordenParcial()) {
            System.out.println(string);
        }
        
        
    }
}
