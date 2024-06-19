package ta5.grafos;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        LinkedList<TVertice> listaDeJuanes = new LinkedList<TVertice>();
        if (this.getVertices().get(etiquetaOrigen) != null) {
            this.getVertices().get(etiquetaOrigen).bea(listaDeJuanes);
        }
        return listaDeJuanes;

    }

    @Override
    public Collection<TVertice> bea() {
        LinkedList<TVertice> listaDeJuanes = new LinkedList<TVertice>();
        if (!this.getVertices().isEmpty()) {
            this.getVertices().values().iterator().next().bea(listaDeJuanes);
        }
        return listaDeJuanes;

    }

    @Override
    public boolean esConexo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esConexo'");
    }

    @Override
    public boolean conectados(TVertice origen, TVertice destino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'conectados'");
    }
}
