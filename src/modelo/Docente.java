package modelo;

import visitor.Visitor;

public class Docente extends Persona {

    public Docente(String codigo, String nombres, String direccion) {
        super(codigo, nombres, direccion);
    }

   
    @Override
    public void accept(Visitor visitor) {
        visitor.visitar(this);
    }

    @Override
    public String toString() {
        return "DOCENTE   " + super.toString();
    }
}
