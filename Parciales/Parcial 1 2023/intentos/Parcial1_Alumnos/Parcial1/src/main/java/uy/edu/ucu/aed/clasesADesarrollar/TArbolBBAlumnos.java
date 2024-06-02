package uy.edu.ucu.aed.clasesADesarrollar;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.TArbolBB;
import uy.edu.ucu.aed.interfaces.IArbolBBAlumnos;

// Se puede modificar la clase de la cual se hereda si se considera necesario
public class TArbolBBAlumnos extends TArbolBB<Alumno> implements IArbolBBAlumnos {

    private TElementoABAlumno raiz = null;

    public boolean insertar(TElementoABAlumno unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares) {
        this.getRaiz().armarSubgrupos(grupoImpares, grupoPares, 0);
    }

    /**
     * @return agrega a la lista el nodo si el nodo solamente pertence al curso indicado
     */
    public void armarIndice(String curso, TArbolBB<Alumno> arbol) {
        if (raiz != null){
            raiz.armarIndice(curso, arbol);
        }
    }


}