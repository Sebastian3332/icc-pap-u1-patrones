package icc.pap.u1.patrones;

public class App {
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
    }
}