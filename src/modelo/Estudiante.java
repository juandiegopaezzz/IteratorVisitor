
package modelo;

import visitor.Visitor;

public class Estudiante extends Persona {

    public Estudiante(String codigo, String nombres, String direccion) {
        super(codigo, nombres, direccion);
    }

    // El Visitor visita a este Estudiante
    @Override
    public void accept(Visitor visitor) {
        visitor.visitar(this);
    }

    @Override
    public String toString() {
        return "ESTUDIANTE " + super.toString();
    }
}