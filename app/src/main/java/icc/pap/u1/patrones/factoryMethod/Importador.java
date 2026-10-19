package icc.pap.u1.patrones.factoryMethod;

import java.util.ArrayList;
import java.util.List;

// mantener el proceso de informacion
public abstract class Importador {

    // Factory Method
    protected abstract LectorLinea crearLector();

    final List<Lectura> importacion(List<String> lecturas) {
        LectorLinea lector = crearLector(); //Polimorfica
        List<Lectura> resultado = new ArrayList<>();
        for(String lectura : lecturas) {
            if(lectura.isBlank()) continue;
            try {
                resultado.add(lector.leer(lectura));
            } catch (Exception e) {
                throw new IllegalArgumentException("Linea mal formada");
            }
        }
        return resultado;
    }
}
