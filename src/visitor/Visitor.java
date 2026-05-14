package visitor;



import modelo.Docente;
import modelo.Estudiante;

public interface Visitor {
    void visitar(Estudiante estudiante);
    void visitar(Docente docente);
}
 