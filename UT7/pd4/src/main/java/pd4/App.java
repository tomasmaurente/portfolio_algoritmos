package pd4;

import java.util.Collection;

import pd4.grafoDirigido.TGrafoDirigido;
import pd4.grafoDirigido.UtilGrafos;
import pd4.utils.TCaminos;

public class App 
{

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
            "pd4\\src\\main\\java\\pd4\\utils\\aeropuertos_2.txt",
            "pd4\\src\\main\\java\\pd4\\utils\\conexiones_2.txt",
                false, TGrafoDirigido.class);

        Collection<Comparable> verticesVisitadosDesdeMtvd = gd.bpf("Buenos_Aires");
        for (Comparable vertice : verticesVisitadosDesdeMtvd) {
            System.out.println(vertice);
        }

        TCaminos caminosDeMtvdARio = gd.todosLosCaminos("Asuncion", "Florianopolis");
        System.out.println(caminosDeMtvdARio.imprimirCaminos());
    }
}
