
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;

/**
 *
 * @author ernesto
 */
public class Parcial2 {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                PlantillaMedicos hospital = new PlantillaMedicos();
                /**
                 * 1. Crear los médicos y cargarlos en la planilla del hospital a partir
                 * del archivo "medicos.txt” Cada línea tiene cédula, nombre,
                 * especialidad y año de ingreso del médico
                 */

                String[] lineasMedicos = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Tomas\\Desktop\\Algoritmos\\portfolio_algoritmos\\Parciales viejos\\Parcial 2 2018\\PARCIAL2\\src\\medicos.txt");

                Medico medico;
                for (String l : lineasMedicos) {
                        String[] datos = l.split(",");
                        medico = new Medico(Integer.valueOf(datos[0]), datos[1], datos[2], Integer.valueOf(datos[3]));
                        TElementoAB<Medico> nuevoNodo = new TElementoAB<>(medico.getCedula(), medico);
                        hospital.insertar(nuevoNodo);
                }

                /*
                 * 
                 * 2. Emitir por consola el listado de médicos de la plantilla del hospital
                 * ordenado en forma ascendente por número de Cédula y la Cantidad total de
                 * medicos en la plantilla.
                 * 
                 */

                LinkedList<Medico> medicos = hospital.inOrden();
                int size = medicos.size();
                Medico m;
                while (!medicos.isEmpty()) {
                        m = medicos.removeFirst();
                        System.out.println(m.getCedula() + ", " + m.getNombre() + ", " + m.getEspecialidad());
                }
                System.out.println("La cantidad de medicos en la plantilla es: " + size);

                /*
                 * 
                 * 3. Eliminar de la plantilla los médicos con las siguientes Cédulas:
                 * 7669,
                 * 1632,
                 * 5328,
                 * 1081,
                 * 9069
                 * 
                 */

                hospital.eliminar((Comparable) 7669);
                hospital.eliminar((Comparable) 1632);
                hospital.eliminar((Comparable) 5328);
                hospital.eliminar((Comparable) 1081);
                hospital.eliminar((Comparable) 9069);

                /*
                 * 
                 * 4. Emitir por consola la nueva cantidad de medicos en la plantilla (invocando
                 * al metodo correspondiente del arbol de plantilla)
                 * 
                 */

                System.out.println("La cantidad de medicos en la plantilla es: " + hospital.obtenerTamanio());

                /*
                 * 
                 * 5. Dados los siguientes números de cédula, recuperar los médicos
                 * correspondientes de la plantilla e imprimir por consola sus datos completos:
                 * 8948,
                 * 5683 y
                 * 822
                 * 
                 */

                m = hospital.buscar((Comparable) 8948).getDatos();
                System.out.println(m.getCedula() + ", " + m.getNombre() + ", " + m.getEspecialidad());

                m = hospital.buscar((Comparable) 5683).getDatos();
                System.out.println(m.getCedula() + ", " + m.getNombre() + ", " + m.getEspecialidad());

                m = hospital.buscar((Comparable) 822).getDatos();
                System.out.println(m.getCedula() + ", " + m.getNombre() + ", " + m.getEspecialidad());

                /*
                 * 6. Ejecutar el método “obtenerDirectorio” de la plantilla del hospital,
                 * para la especialidad que se indicará en el pizarrón.
                 */

                TArbolBB nuevoHospital = hospital.obtenerDirectorio("Medicina preventiva y salud publica");
                LinkedList<Medico> nuevosMedicos = nuevoHospital.inOrden();
                int newSize = nuevosMedicos.size();
                while (!nuevosMedicos.isEmpty()) {
                        m = nuevosMedicos.removeFirst();
                        System.out.println(m.getCedula() + ", " + m.getNombre() + ", " + m.getEspecialidad());
                }
                System.out.println("La cantidad de medicos en la plantilla es: " + newSize);
                /*
                 * 7. Con el nuevo directorio obtenido:
                 * a. escribir un archivo “medicos_policlinica.txt” que contenga todos los datos
                 * de los médicos de la especialidad indicada, uno por cada línea,
                 * ordenados alfabéticamente por nombre.
                 * b. Indicar la cantidad total de médicos incluidos en el Directorio.
                 * 
                 */

                nuevosMedicos = nuevoHospital.inOrden();
                System.out.println(nuevosMedicos.size());
                String[] a = new String[nuevosMedicos.size()];
                int cont = 0;
                while (!nuevosMedicos.isEmpty()) {
                        m = nuevosMedicos.removeFirst();
                        a[cont] = m.getCedula() + ", " + m.getNombre() + ", " + m.getEspecialidad();
                        cont++;
                }
                ManejadorArchivosGenerico.escribirArchivo("src/medicosEspecialidad.txt", a);
                System.out.println("La cantidad de medicos en la plantilla es: " + newSize);

                /*
                 * Tests
                 */
                hospital = new PlantillaMedicos();
                TElementoAB<Medico> nodo1 = new TElementoAB<Medico>(8, new Medico(8, "Maria", "Cardiologia", 2013));
                TElementoAB<Medico> nodo2 = new TElementoAB<Medico>(5, new Medico(5, "Valentina", "Cirugia", 2014));
                TElementoAB<Medico> nodo3 = new TElementoAB<Medico>(3, new Medico(3, "Jose", "Pediatria", 2013));
                TElementoAB<Medico> nodo4 = new TElementoAB<Medico>(6, new Medico(6, "Ana", "Cirugia", 2013));
                TElementoAB<Medico> nodo5 = new TElementoAB<Medico>(4, new Medico(4, "Florencia", "Pediatria", 2013));
                TElementoAB<Medico> nodo6 = new TElementoAB<Medico>(2, new Medico(2, "Juan", "Cardiologia", 2001));
                TElementoAB<Medico> nodo7 = new TElementoAB<Medico>(1, new Medico(1, "Pedro", "Cirugia", 2017));
                TElementoAB<Medico> nodo8 = new TElementoAB<Medico>(7, new Medico(7, "Martin", "Pediatria", 2015));

                hospital.insertar(nodo1);
                hospital.insertar(nodo2);
                hospital.insertar(nodo3);
                hospital.insertar(nodo4);
                hospital.insertar(nodo5);
                hospital.insertar(nodo6);
                hospital.insertar(nodo7);
                hospital.insertar(nodo8);

                // Test 1, obtener directorio no contiene otras especialidades
                System.out.println("Test 1");
                nuevoHospital = hospital.obtenerDirectorio("Cirugia");
                nuevosMedicos = nuevoHospital.inOrden();
                newSize = nuevosMedicos.size();
                while (!nuevosMedicos.isEmpty()) {
                        m = nuevosMedicos.removeFirst();
                        System.out.println(m.getEspecialidad().equals("Cirugia"));
                } 


                // Test 2, obtener directorio devuelve un arbol vacio si no hay coincidencias
                System.out.println("Test 2");
                nuevoHospital = hospital.obtenerDirectorio("especialidad no existente");
                System.out.println(nuevoHospital.esVacio());



                // Test 3, obtener directorio devuelve vacio si null es pasado como parametro
                System.out.println("Test 3");
                nuevoHospital = hospital.obtenerDirectorio("especialidad no existente");
                System.out.println(nuevoHospital.esVacio());

        }
}
