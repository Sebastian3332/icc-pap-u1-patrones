package icc.pap.u1.patrones.comportamiento.observer2.observers;

import java.util.function.Consumer;

import icc.pap.u1.patrones.comportamiento.observer2.CambioEstudiante;

public class SeguimientoAcademico implements Consumer<CambioEstudiante> {
    

    @Override 
    public void accept(CambioEstudiante cambio) {
        if(cambio.atributo().equals("Promedio")) {
            return;
        }
        double anterior = (double) cambio.old();
        double nuevo = (double) cambio.nuevo();

        if(anterior >= 7.0 && nuevo < 7.0) {
            System.out.println("[ACADEMICO] Bajo rendimiento" + cambio.est());
        }

        if(anterior < 7.0 && nuevo >= 7.0) {
            System.out.println("[ACADEMICO] Recuperacion academica" + cambio.est());
        }
    }
}
