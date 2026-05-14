/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visitor;

// Visitor concreto: valida datos y envía notificación si faltan datos

import modelo.Docente;
import modelo.Estudiante;
import modelo.Persona;

// Visitor concreto: valida datos y envía notificación si faltan datos
public class ValidadorVisitor implements Visitor {

    @Override
    public void visitar(Estudiante estudiante) {
        validarPersona(estudiante, "Estudiante");
    }

    @Override
    public void visitar(Docente docente) {
        validarPersona(docente, "Docente");

        // Validación extra para docentes: código máximo 4 dígitos
        if (docente.getCodigo().length() > 4) {
            enviarNotificacion(docente, "ADVERTENCIA - CODIGO DE DOCENTE SUPERA 4 DIGITOS: " + docente.getCodigo());
        }
    }

    private void validarPersona(Persona persona, String tipo) {
        boolean datosCompletos = true;
        StringBuilder problemas = new StringBuilder();

        if (persona.getNombres() == null || persona.getNombres().isBlank()) {
            datosCompletos = false;
            problemas.append("- Falta nombre\n");
        }
        if (persona.getDireccion() == null || persona.getDireccion().isBlank()) {
            datosCompletos = false;
            problemas.append("- Falta direccion\n");
        }
        if (persona.getTelefonos() == null || persona.getTelefonos().isEmpty()) {
            datosCompletos = false;
            problemas.append("- Falta lista de telefonos\n");
        }

        if (datosCompletos) {
            System.out.println("OK - " + tipo + " [" + persona.getCodigo() + "] " + persona.getNombres() + " -> datos completos.");
        } else {
            enviarNotificacion(persona, "Datos incompletos:\n" + problemas);
        }
    }

    private void enviarNotificacion(Persona persona, String mensaje) {
        System.out.println("NOTIFICACION para [" + persona.getCodigo() + "] " + persona.getNombres() + ": " + mensaje);
    }
}