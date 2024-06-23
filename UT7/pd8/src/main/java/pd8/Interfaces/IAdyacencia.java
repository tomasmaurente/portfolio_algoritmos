package pd8.Interfaces;

import pd8.grafoDirigido.TVertice;

public interface IAdyacencia {

    double getCosto();

    TVertice getDestino();

    Comparable getEtiqueta();
    
}
