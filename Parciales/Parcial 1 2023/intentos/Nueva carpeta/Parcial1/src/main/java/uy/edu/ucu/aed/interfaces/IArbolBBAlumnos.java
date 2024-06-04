package uy.edu.ucu.aed.interfaces;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.TArbolBB;

public interface IArbolBBAlumnos {
    public void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares);
}
