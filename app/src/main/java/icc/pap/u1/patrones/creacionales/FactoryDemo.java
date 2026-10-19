package icc.pap.u1.patrones.creacionales;

public class FactoryDemo {
    public Notificacion crearNotificacion(String tipo) {
        if (tipo.equalsIgnoreCase("email")) {
            return new Email();
        } else if (tipo.equalsIgnoreCase("sms")) {
            return new SMS();
        } else {
            return null;
        }
    }
}