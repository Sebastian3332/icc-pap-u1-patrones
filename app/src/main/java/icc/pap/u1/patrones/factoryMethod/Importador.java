package icc.pap.u1.patrones.factoryMethod;

import java.util.ArrayList;
import java.util.List;

///mantener el proceso de importacion y delega la creacion
public abstract class Importador {

    // Factory Method
    protected abstract LectorLinea crearLector();

    public final List<Lector> importacion(List<String> Lecturas) {
        LectorLinea lector = crearLector();
        List<Lector> resultado = new ArrayList<>();
        for (String lectura : Lecturas) {
            if (lectura.isBlank()) {
                continue;
            }
            try {
                resultado.add(lector.leerLinea(lectura));
            } catch (Exception e) {
                System.out.println("Error en la lectura de la linea: " + lectura);
            }

        }
        return resultado;
    }

}