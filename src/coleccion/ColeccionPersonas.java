/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coleccion;

import iterator.Iterator;
import java.util.ArrayList;
import java.util.TreeSet;
import modelo.Persona;

// Colección que almacena personas en TreeSet y ArrayList
// y provee dos recorridos diferentes (patrón Iterator)
public class ColeccionPersonas {

    private TreeSet<Persona> treeSet;
    private ArrayList<Persona> arrayList;

    public ColeccionPersonas() {
        treeSet = new TreeSet<>();
        arrayList = new ArrayList<>();
    }

    public void agregar(Persona p) {
        treeSet.add(p);
        arrayList.add(p);
    }

    // ─── Recorrido 1: Iterator sobre TreeSet (orden alfabético por código) ───
    public Iterator<Persona> iteratorOrdenado() {
        // Convertimos el TreeSet a array para recorrerlo con nuestro Iterator
        Persona[] arr = treeSet.toArray(new Persona[0]);
        return new Iterator<Persona>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public Persona next() {
                return arr[index++];
            }
        };
    }

    // ─── Recorrido 2: Iterator sobre ArrayList (orden de inserción) ───
    public Iterator<Persona> iteratorInsercion() {
        return new Iterator<Persona>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < arrayList.size();
            }

            @Override
            public Persona next() {
                return arrayList.get(index++);
            }
        };
    }
}
