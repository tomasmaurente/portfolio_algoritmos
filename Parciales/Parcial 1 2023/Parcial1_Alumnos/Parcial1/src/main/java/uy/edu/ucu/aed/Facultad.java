package uy.edu.ucu.aed;

import java.util.LinkedList;
import java.util.List;

import uy.edu.ucu.aed.clasesInmutables.Alumno;
import uy.edu.ucu.aed.clasesInmutables.Curso;
import uy.edu.ucu.aed.clasesInmutables.TElementoAB;

public class Facultad {
  
    // Variable de instancia necesarias
    private TArbolBBAlumnos arbolAlumnos = new TArbolBBAlumnos();
    private List<Alumno> alumnos;
    private List<Curso>  cursos;

    Facultad( LinkedList<Alumno> alumnos, LinkedList<Curso> cursos) {
      this.alumnos = alumnos;
      this.cursos  = cursos;
    }

    public TArbolBBAlumnos armarIndiceCurso(String cursoNombre)
    {
        Integer indexCurso = null;
        for (Curso curso : cursos) {
          if (curso.getNombre().equals(cursoNombre)){
            indexCurso = curso.getIdentificador();
            break;
          }  
        }

        for (Alumno alumno : alumnos) {
          for (int index : alumno.getCursos()) {
            if (index == indexCurso){
              TElementoAB<Alumno> nuevoAlumno = new TElementoAB<Alumno>(
                alumno.getNombre() + alumno.getApellido(),alumno);
              arbolAlumnos.insertar(nuevoAlumno);
            }
          }
        }

        return arbolAlumnos;
    }
}
