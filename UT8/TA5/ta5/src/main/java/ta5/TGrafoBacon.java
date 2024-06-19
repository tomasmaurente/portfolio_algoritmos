package ta5;

import java.util.Collection;

import ta5.grafos.TArista;
import ta5.grafos.TGrafoNoDirigido;
import ta5.grafos.TVertice;

public class TGrafoBacon extends TGrafoNoDirigido implements IGrafoKevinBacon {

    public TGrafoBacon(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    /*
     * Siempre arranco desde kevin bacon
     */
    @Override
    public int numBacon(Comparable actor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numBacon'");
    }
    
}
