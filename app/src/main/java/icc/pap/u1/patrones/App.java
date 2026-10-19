package icc.pap.u1.patrones;

import java.util.List;

import icc.pap.u1.patrones.creacionales.FactoryDemo;
import icc.pap.u1.patrones.creacionales.Notificacion;
import icc.pap.u1.patrones.factoryMethod.Importador;
import icc.pap.u1.patrones.factoryMethod.ImportadorPuntoComa;

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
        Importador imPC = new ImportadorPuntoComa();

        System.out.println(imPC.importacion(List.of("S01", "22.5", "C", "S02", "18", "C")));
    }
}