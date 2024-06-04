package uy.edu.ucu.aed;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.TArbolBB;
import uy.edu.ucu.aed.interfaces.IArbolBBAlumnos;

// Se puede modificar la clase de la cual se hereda si se considera necesario
public class TArbolBBAlumnos extends TArbolBB<Alumno> implements IArbolBBAlumnos {

    @Override
    public void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares) {
        this.getRaiz().armarSubgrupos(grupoImpares, grupoPares, 0);
    }

    public void armarIndiceCurso(int cursoIdentificador, TArbolBBAlumnos alumnosCurso)
    {
      this.getRaiz().armarIndiceCurso(cursoIdentificador, alumnosCurso);
    }

}