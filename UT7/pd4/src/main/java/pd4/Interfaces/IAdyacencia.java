package pd4.Interfaces;

import pd4.grafoDirigido.TVertice;

public interface IAdyacencia {

    double getCosto();

    TVertice getDestino();

    Comparable getEtiqueta();
    
}
