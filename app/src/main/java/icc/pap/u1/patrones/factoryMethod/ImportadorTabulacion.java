package icc.pap.u1.patrones.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public class ImportadorTabulacion extends Importador {

    @Override
    protected LectorLinea crearLector() {
        return new LectorTabulacion();
    }

}