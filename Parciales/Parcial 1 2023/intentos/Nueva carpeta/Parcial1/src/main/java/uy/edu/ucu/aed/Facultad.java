package uy.edu.ucu.aed;

import java.util.LinkedList;
import java.util.List;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.Curso;
import uy.edu.ucu.aed.clases.TArbolBB;

public class Facultad extends TArbolBBAlumnos{
    
    private TArbolBBAlumnos alumnosArbol = new TArbolBBAlumnos();
    private List<Alumno> alumnosLista = null;
    private List<Curso>  cursos  = null;

    public Facultad(
      List<Alumno> alumnos,
      List<Curso>  cursos ){
        alumnosLista = alumnos;
        this.cursos = cursos;

        for (Alumno alumno : alumnos) {
          insertar(alumno);
      }
    }

    public boolean insertar(Alumno alumno){
      Comparable etiqueta = alumno.getNombre() + alumno.getApellido();
      TElementoAB<Alumno> nuevoAlumno = new TElementoAB<Alumno>(etiqueta, alumno);
      return alumnosArbol.insertar(nuevoAlumno);
    }

    public void armarSubgrupos(TArbolBB<Alumno> grupoImpares, TArbolBB<Alumno> grupoPares) {
      alumnosArbol.armarSubgrupos(grupoImpares, grupoPares);
    }

    public TArbolBBAlumnos armarIndiceCurso(String cursoNombre)
    {
      TArbolBBAlumnos alumnosCurso = new TArbolBBAlumnos();
      for (Curso curso : cursos) {
        if (curso.getNombre().equals(cursoNombre)){
          alumnosArbol.armarIndiceCurso(curso.getIdentificador(), alumnosCurso);
          break;
        }
      }
      return alumnosCurso;
    }

    public LinkedList<T> inOrden(){
      alumnosArbol.inOrden();
    }
}
