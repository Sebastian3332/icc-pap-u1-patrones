package icc.pap.u1.patrones.comportamiento.observer2;

import java.util.function.Consumer;
import icc.pap.u1.patrones.comportamiento.observer2.observers.SeguimientoAcademico;

public class AppObserverPractica {

    private static String evaluarNivelAsistencia(int asistencias) {
        if (asistencias <= 2) return "Normal";
        if (asistencias <= 5) return "Advertencia";
        return "Crítico";
    }

    public static void main(String[] args) {
        System.out.println(" INICIALIZACION DE ESTUDIANTES ");
        Estudiante ana = new Estudiante("EST001", "Ana Torres", 8.5, 1, Matricula.Activo);
        Estudiante luis = new Estudiante("EST002", "Luis Perez", 7.2, 4, Matricula.Activo);
        Estudiante maria = new Estudiante("EST003", "Maria Lopez", 9.1, 0, Matricula.Activo);

        Consumer<CambioEstudiante> auditoria = cambio -> {
            System.out.printf("[AUDITORIA] Estudiante: %s | Atributo: %s | Anterior: %s -> Nuevo: %s%n",
                    cambio.est().getNombre(), cambio.atributo(), cambio.old(), cambio.nuevo());
        };

        SeguimientoAcademico obAcademico = new SeguimientoAcademico();

        Consumer<CambioEstudiante> controlAsistencia = cambio -> {
            if (!cambio.atributo().equals("asistencias")) return;
            int ant = (int) cambio.old();
            int nuevo = (int) cambio.nuevo();
            String nivelAnt = evaluarNivelAsistencia(ant);
            String nivelNuevo = evaluarNivelAsistencia(nuevo);

            if (!nivelAnt.equals(nivelNuevo)) {
                System.out.printf("[ASISTENCIA] %s cambio de nivel de asistencia: %s -> %s (Total inasistencias: %d)%n",
                        cambio.est().getNombre(), nivelAnt, nivelNuevo, nuevo);
            }
        };

        Consumer<CambioEstudiante> controlMatricula = cambio -> {
            if (!cambio.atributo().equals("matricula")) return;
            Matricula anterior = (Matricula) cambio.old();
            Matricula nuevo = (Matricula) cambio.nuevo();
            System.out.printf("[MATRICULA] El estudiante %s cambio su estado de matricula de %s a %s.%n",
                    cambio.est().getNombre(), anterior, nuevo);
        };

        Consumer<CambioEstudiante> seguimientoIntegral = cambio -> {
            Estudiante e = cambio.est();
            if (e.getPromedio() < 7.0 && e.getAsistencias() >= 6 && e.getMatricula() == Matricula.Activo) {
                System.out.printf("[ALERTA INTEGRAL] ¡Riesgo detectado en %s! Promedio: %.2f, Inasistencias: %d, Matricula: %s%n",
                        e.getNombre(), e.getPromedio(), e.getAsistencias(), e.getMatricula());
            }
        };

        Consumer<CambioEstudiante> notificadorRepresentante = cambio -> {
            Estudiante e = cambio.est();
            boolean notificar = false;
            String motivo = "";

            if (cambio.atributo().equals("promedio") && e.getPromedio() < 6.0) {
                notificar = true;
                motivo = "Promedio menor a 6.0 (" + e.getPromedio() + ")";
            } else if (cambio.atributo().equals("asistencias") && e.getAsistencias() >= 8) {
                notificar = true;
                motivo = "Inasistencias acumuladas altas (" + e.getAsistencias() + ")";
            } else if (cambio.atributo().equals("matricula") && e.getMatricula() == Matricula.Suspendido) {
                notificar = true;
                motivo = "Estudiante suspendido";
            }

            if (notificar) {
                System.out.printf("[REPRESENTANTE] Notificando al representante de %s por: %s%n", e.getNombre(), motivo);
            }
        };

        for (Estudiante est : new Estudiante[]{ana, luis, maria}) {
            est.suscribir(auditoria);
            est.suscribir(obAcademico);
            est.suscribir(controlAsistencia);
            est.suscribir(seguimientoIntegral);
        }

        maria.suscribir(controlMatricula);

        ana.suscribir(notificadorRepresentante);
        luis.suscribir(notificadorRepresentante);

        System.out.println(" CASO 1: Disminucion del rendimiento academico Ana ");
        ana.setPromedio(6.5);

        System.out.println(" CASO 2: Recuperación academica Ana ");
        ana.setPromedio(7.8);

        System.out.println(" CASO 3: Cambio de nivel de asistencia Luis ");
        luis.setAsistencias(7);

        System.out.println(" CASO 4: Modificacion del estado de matricula Maria ");
        maria.setMatricula(Matricula.Suspendido);
        maria.setMatricula(Matricula.Activo);

        System.out.println(" CASO 5: Identificacion de riesgo integral Luis ");
        luis.setPromedio(6.4);

        System.out.println(" CASO 6: Modificaciones sin cambios reales Maria ");
        maria.setPromedio(9.1);

        System.out.println(" CASO 7: Observacion de multiples estudiantes ");
        ana.setAsistencias(3);

        System.out.println(" CASO 8: Incorporacion y prueba del NotificadorRepresentante ");
        System.out.println("-> Probando promedio inferior a 6.0 en Ana:");
        ana.setPromedio(5.5);

        System.out.println("-> Probando inasistencias >= 8 en Luis:");
        luis.setAsistencias(9);

        System.out.println("-> Probando suspension en Ana:");
        ana.setMatricula(Matricula.Suspendido);
    }
}