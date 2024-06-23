package pd7.Interfaces;

import pd7.grafoDirigido.TVertice;

public interface IAdyacencia {

    double getCosto();

    TVertice getDestino();

    Comparable getEtiqueta();
    
}
