package icc.pap.u1.patrones.comportamiento.observer2;

import java.util.function.Consumer;

import icc.pap.u1.patrones.comportamiento.observer2.observers.SeguimientoAcademico;

public class AppObserverPractica {


    public static void main(String[] args) {

        Estudiante ana = new Estudiante("001", "Pupilo", 8.5, 1, Matricula.Activo);
        Consumer<CambioEstudiante> auditoria = cambio -> {
            System.out.printf("[AUDITORIA] %s | %s: -> %s%n", cambio.est(), cambio.atributo(), cambio.atributo(), cambio.old(), cambio.nuevo());
        };

        SeguimientoAcademico obAcademico = new SeguimientoAcademico();

        ana.suscribir(auditoria);
        ana.setCodigo("008");


    }

}