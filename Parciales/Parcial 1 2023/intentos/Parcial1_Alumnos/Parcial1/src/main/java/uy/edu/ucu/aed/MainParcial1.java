package uy.edu.ucu.aed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.Curso;
import uy.edu.ucu.aed.clases.TArbolBB;
import uy.edu.ucu.aed.clasesADesarrollar.Facultad;
import uy.edu.ucu.aed.clasesADesarrollar.TArbolBBAlumnos;

public class MainParcial1 
{
    public static void main( String[] args )
    {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        List<Curso>  cursos  = new ArrayList<Curso>();

        // Cargar alumnos
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/alumnos.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int identificador = Integer.parseInt(fields[0]);
                String nombre = fields[1];
                String apellido = fields[2];
                List<Integer> _cursos = new ArrayList<>();
                for (int i = 3; i < fields.length; i++) {
                    _cursos.add(Integer.parseInt(fields[i]));
                }

                Alumno nuevoAlumno = new Alumno(identificador, nombre, apellido, _cursos);
                alumnos.add(nuevoAlumno);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar alumnos: " + e.getMessage());
        }

        // Cargar cursos
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/cursos.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int identificador = Integer.parseInt(fields[0]);
                String nombre = fields[1];

                Curso nuevoCurso = new Curso(identificador, nombre);
                cursos.add(nuevoCurso);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar cursos: " + e.getMessage());
        }

        // Crear Facultad (modificar según cambio de parámetros)
        Facultad facultad = new Facultad(/**/);

        // Armar alumnos de curso
        String cursoNombre = "Algoritmos";

        // Invocar método desarrollado
        TArbolBBAlumnos alumnosDelCurso = facultad.armarIndiceCurso(cursoNombre);

        // Armar subgrupos
        TArbolBB<Alumno> gruposPares = null;
        TArbolBB<Alumno> gruposImpares = null;

        alumnosDelCurso.armarSubgrupos(gruposPares, gruposImpares);

        // Mostrar en consola alumnos del curso (alumnosDelCurso)

        // Guardar alumnos del curso en archivo
    }
}
