package pd8.grafoDirigido;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import pd8.Interfaces.IVertice;
import pd8.utils.TCamino;
import pd8.utils.TCaminos;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numBpf = 0;
    private int cantidadDesc;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public T getDatos() {
        return datos;
    }

    public void bpf(Collection<Comparable> visitados) {
        setVisitado(true);
        visitados.add(this.getEtiqueta());
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                caminoPrevio.agregarAdyacencia(adyacente);
                if (vertAdy.etiqueta.compareTo(etVertDest) == 0) {
                    todosLosCaminos.getCaminos().add(caminoPrevio.copiar());
                } else {
                    vertAdy.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                }
                caminoPrevio.eliminarAdyacencia(adyacente);
            }
        }
        setVisitado(false);
        return todosLosCaminos;
    }

    public void clasificarArcos(
        List<TArista> arcosArbol,
        List<TArista> arcosRetroceso, 
        List<TArista> arcosAvance,
        List<TArista> arcosCruzados) {
                
        setVisitado(true);
        for (TAdyacencia adyacencia : getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            TArista arista = new TArista(this.etiqueta, destino.etiqueta, adyacencia.getCosto());
            if (!destino.getVisitado()) {
                arcosArbol.add(arista);
                destino.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
            } else {
                if (this.numBpf <= destino.numBpf && destino.numBpf <= this.numBpf + this.cantidadDesc) {
                    arcosAvance.add(arista);
                } else if (destino.numBpf <= this.numBpf && this.numBpf <= destino.numBpf + destino.cantidadDesc) {
                    arcosRetroceso.add(arista);
                } else {
                    arcosCruzados.add(arista);
                }
            }
        }
    }

    public int asignaNumBpf(int num) {
        setVisitado(true);
        this.numBpf = num;
        for (TAdyacencia tAdyacencia : adyacentes) {
            TVertice destino = tAdyacencia.getDestino();
            if (!destino.getVisitado()) {
                num = destino.asignaNumBpf(num + 1);
            }
        }
        return num;
    }

    public int cantDescendientes() {
        setVisitado(true);
        int descendientes = 0;
        for (TAdyacencia tAdyacencia : adyacentes) {
            TVertice destino = tAdyacencia.getDestino();
            if (!destino.getVisitado()) {
                descendientes += destino.cantDescendientes();
            }
        }
        this.cantidadDesc = descendientes;
        return descendientes + 1;
    }

}
