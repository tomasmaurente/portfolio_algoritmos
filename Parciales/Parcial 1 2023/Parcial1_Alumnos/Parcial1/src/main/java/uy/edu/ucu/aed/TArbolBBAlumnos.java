package uy.edu.ucu.aed;

import uy.edu.ucu.aed.clasesInmutables.Alumno;
import uy.edu.ucu.aed.clasesInmutables.TArbolBB;
import uy.edu.ucu.aed.clasesInmutables.TElementoAB;
import uy.edu.ucu.aed.interfaces.IArbolBBAlumnos;

// Se puede modificar la clase de la cual se hereda si se considera necesario
public class TArbolBBAlumnos extends TArbolBB<Alumno> implements IArbolBBAlumnos {

    @Override
    public void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares) {
        armarSubgrupos(grupoImpares, grupoPares, 0, this.getRaiz());
    }

    private void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares, int nivel, TElementoAB<Alumno> nodo) {
        if (nivel % 2 == 0){
            TElementoAB<Alumno> nuevoAlumno = new TElementoAB<Alumno>(
                nodo.getEtiqueta(),nodo.getDatos());
            grupoPares.insertar(nuevoAlumno);
        }
        if (nivel % 2 != 0){
            TElementoAB<Alumno> nuevoAlumno = new TElementoAB<Alumno>(
                nodo.getEtiqueta(),nodo.getDatos());
            grupoImpares.insertar(nuevoAlumno);
        }
        if (nodo.getHijoIzq() != null){
            armarSubgrupos(grupoImpares, grupoPares, nivel + 1, nodo.getHijoIzq());
        }
        if (nodo.getHijoDer() != null){
            armarSubgrupos(grupoImpares, grupoPares, nivel + 1, nodo.getHijoDer());
        }
    }
}