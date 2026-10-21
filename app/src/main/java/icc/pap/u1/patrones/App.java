package icc.pap.u1.patrones;

import java.util.List;

import icc.pap.u1.patrones.creacionales.FactoryDemo;
import icc.pap.u1.patrones.creacionales.Notificacion;
import icc.pap.u1.patrones.factoryMethod.Importador;
import icc.pap.u1.patrones.factoryMethod.ImportadorPuntoComa;
import icc.pap.u1.patrones.factoryMethod.ImportadorTabulacion;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        FactoryDemo fabrica = new FactoryDemo();

        Notificacion notificacion1 = fabrica.crearNotificacion("email");
        Notificacion notificacion2 = fabrica.crearNotificacion("sms");

        if (notificacion1 != null) {
            notificacion1.enviar();
        }

        if (notificacion2 != null) {
            notificacion2.enviar();
        }

        runFactoryMethod();
    }

    private static void runFactoryMethod() {
        Importador impPC = new ImportadorPuntoComa();
        System.out.println(impPC.importacion(List.of("SO1;22.5;C","SO2;18;C")));
        Importador impTab = new ImportadorTabulacion();
        System.out.println(impTab.importacion(List.of("SO1\t22.5\tC","SO2\t18\tC")));
    }

}