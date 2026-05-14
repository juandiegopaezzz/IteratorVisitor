/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import coleccion.ColeccionPersonas;
import iterator.Iterator;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Persona;
import visitor.ValidadorVisitor;

public class Main {
    public static void main(String[] args) {

        // ── Crear colección ──────────────────────────────────────────
        ColeccionPersonas coleccion = new ColeccionPersonas();

        // Estudiantes con datos completos
        Estudiante e1 = new Estudiante("E003", "Ana Garcia", "Calle 10 #5-20");
        e1.agregarTelefono("3001234567");

        Estudiante e2 = new Estudiante("E001", "Carlos Perez", "Carrera 7 #45-12");
        e2.agregarTelefono("3119876543");
        e2.agregarTelefono("6012345678");

        Estudiante e3 = new Estudiante("E002", "Laura Martinez", "");

        Docente d1 = new Docente("D001", "Prof. Ramirez", "Av. Principal #1");
        d1.agregarTelefono("3205554433");

        Docente d2 = new Docente("D10050", "Prof. Torres", "Calle 50 #8-30");
        d2.agregarTelefono("3154443322");

        Docente d3 = new Docente("D002", "Prof. Lopez", "");

        coleccion.agregar(e1);
        coleccion.agregar(e2);
        coleccion.agregar(e3);
        coleccion.agregar(d1);
        coleccion.agregar(d2);
        coleccion.agregar(d3);

        // Recorrido 1: TreeSet (orden por codigo)
        System.out.println("==============================================");
        System.out.println("  RECORRIDO 1 - TreeSet (orden por codigo)");
        System.out.println("==============================================");
        Iterator<Persona> it1 = coleccion.iteratorOrdenado();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        // Recorrido 2: ArrayList (orden de insercion)
        System.out.println("\n==============================================");
        System.out.println("  RECORRIDO 2 - ArrayList (orden de insercion)");
        System.out.println("==============================================");
        Iterator<Persona> it2 = coleccion.iteratorInsercion();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        // Patron Visitor: validar datos
        System.out.println("\n==============================================");
        System.out.println("  VISITOR - Validacion de datos completos");
        System.out.println("==============================================");
        ValidadorVisitor validador = new ValidadorVisitor();
        Iterator<Persona> it3 = coleccion.iteratorOrdenado();
        while (it3.hasNext()) {
            it3.next().accept(validador);
        }
    }
}
