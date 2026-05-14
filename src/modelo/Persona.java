/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import visitor.Visitor;


public abstract class Persona implements Comparable<Persona> {
    protected String codigo;
    protected String nombres;
    protected String direccion;
    protected List<String> telefonos;

    public Persona(String codigo, String nombres, String direccion) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefonos = new ArrayList<>();
    }

    public void agregarTelefono(String telefono) {
        telefonos.add(telefono);
    }

    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getDireccion() { return direccion; }
    public List<String> getTelefonos() { return telefonos; }

    @Override
    public int compareTo(Persona otra) {
        return this.codigo.compareTo(otra.codigo);
    }

    public abstract void accept(Visitor visitor);

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombres + " - " + direccion +
               " | Telefonos: " + (telefonos.isEmpty() ? "NINGUNO" : telefonos);
    }
}