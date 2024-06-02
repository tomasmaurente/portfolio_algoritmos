package uy.edu.ucu.aed.interfaces;

import uy.edu.ucu.aed.clasesInmutables.Alumno;
import uy.edu.ucu.aed.clasesInmutables.TArbolBB;

public interface IArbolBBAlumnos {
    public void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares);
}
