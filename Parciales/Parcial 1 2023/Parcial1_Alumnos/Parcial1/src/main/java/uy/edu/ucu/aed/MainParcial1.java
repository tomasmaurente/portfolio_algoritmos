package uy.edu.ucu.aed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uy.edu.ucu.aed.clasesInmutables.Alumno;
import uy.edu.ucu.aed.clasesInmutables.Curso;
import uy.edu.ucu.aed.clasesInmutables.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.clasesInmutables.TArbolBB;

/**
 * Parcial 1
 *
 */
public class MainParcial1 
{
    public static void main( String[] args )
    {
        LinkedList<Alumno> alumnos = new LinkedList<Alumno>();
        LinkedList<Curso>  cursos =  new LinkedList<Curso>();

        // Cargar alumnos
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\Parciales viejos\\Parcial 1 2023\\Parcial1_Alumnos\\Parcial1\\src\\main\\alumnos.csv"))) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\Parciales viejos\\Parcial 1 2023\\Parcial1_Alumnos\\Parcial1\\src\\main\\cursos.csv"))) {
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
        Facultad facultad = new Facultad( alumnos, cursos);

        // Armar alumnos de curso
        String cursoNombre = "Algoritmos";

        // Invocar método desarrollado
        TArbolBBAlumnos alumnosDelCurso = facultad.armarIndiceCurso(cursoNombre);

        // Armar subgrupos
        TArbolBB<Alumno> gruposPares = new TArbolBB<Alumno>();
        TArbolBB<Alumno> gruposImpares = new TArbolBB<Alumno>();

        alumnosDelCurso.armarSubgrupos(gruposPares, gruposImpares);

        // Mostrar en consola alumnos del curso (alumnosDelCurso)
        LinkedList<Alumno> imp = gruposImpares.inOrden();
        LinkedList<Alumno> par = gruposPares.inOrden();
        
        for (Alumno a : imp) {
            System.out.println(a.getIdentificador());    
        }

        for (Alumno a : par) {
            System.out.println(a.getIdentificador());    
        }
        System.out.println(imp.size());
        System.out.println(par.size());

        // Guardar alumnos del curso en archivo

        LinkedList<Alumno> alumnosCurso = alumnosDelCurso.inOrden();
        int size = alumnosCurso.size();
        String[] s = new String[size];
        for (int i = 0; i < size ; i++) {
            Alumno almuno = alumnosCurso.removeFirst();
            s[i] = almuno.getNombre() + ", " + almuno.getApellido() + ", " + almuno.getIdentificador();
        }
        ManejadorArchivosGenerico.escribirArchivo(
            "C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\Parciales viejos\\Parcial 1 2023\\Parcial1_Alumnos\\Parcial1\\src\\main\\alumnosCurso.csv",
            s);

        
            

    }
}
