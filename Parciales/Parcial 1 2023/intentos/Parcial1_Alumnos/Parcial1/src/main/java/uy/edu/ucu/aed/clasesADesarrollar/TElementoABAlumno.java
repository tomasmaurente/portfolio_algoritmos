package uy.edu.ucu.aed.clasesADesarrollar;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.TArbolBB;
import uy.edu.ucu.aed.clases.TElementoAB;

public class TElementoABAlumno extends TElementoAB<Alumno>{

    private TElementoABAlumno hijoIzq;
    private TElementoABAlumno hijoDer;
    private Alumno datos;

    public TElementoABAlumno(Comparable unaEtiqueta, Alumno unosDatos) {
        super(unaEtiqueta, unosDatos);
    }

    public TElementoABAlumno getHijoIzq() {
        return hijoIzq;
    }

    public TElementoABAlumno getHijoDer() {
        return hijoDer;
    }

    /**
     * @return agrega a la lista el nodo si el nodo solamente pertence al curso indicado
     */
    public void armarIndice(String curso, TArbolBB<Alumno> arbol) {
        
        if (datos.getCursos().length == 1){
            if (curso.equals(datos.getCursos()[0])){
                arbol.insertar(this);
            }
        }
        
        if (this.getHijoIzq() != null) {
            this.getHijoIzq().armarIndice(curso, arbol);
        }
        if (this.getHijoDer() != null) {
            this.getHijoDer().armarIndice(curso, arbol);
        }
    }

}
