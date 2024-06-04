package uy.edu.ucu.aed.clasesADesarrollar;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.Curso;
import uy.edu.ucu.aed.clases.TArbolBB;
import uy.edu.ucu.aed.clases.TElementoAB;


public class Facultad {
    
    private TArbolBB<Curso> cursos = null;
    private TArbolBBAlumnos alumnos = null;

    Facultad() {   
    }

    /*
     * 1.	Implementa en la clase apropiada, un método que, recibiendo por parámetro un nombre de materia, devuelva una instancia de un árbol binario de búsqueda con los alumnos que están inscriptos en ese curso y ningún otro. 
     */
    public TArbolBB<Alumno> armarIndiceCurso(String cursoNombre)
    {
        TArbolBB<Alumno> arbolIndice = new TArbolBBAlumnos();
        alumnos.armarIndice(cursoNombre, arbolIndice);
        return arbolIndice;
    }

    public Boolean addCurso(Curso curso){
      return this.cursos.insertar(
          new TElementoAB<Curso>(curso.getIdentificador(), curso)
        );
    }

    public Boolean addAlumno(Alumno alumno){
      return this.alumnos.insertar(
          new TElementoABAlumno(alumno.getIdentificador(), alumno)
        );
    }
}
