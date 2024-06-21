package pd4.Interfaces;

public interface IArista {

    double getCosto();

    Comparable getEtiquetaDestino();

    Comparable getEtiquetaOrigen();

    void setCosto(double costo);

    void setEtiquetaDestino(Comparable etiquetaDestino);

    void setEtiquetaOrigen(Comparable etiquetaOrigen);
    
}
