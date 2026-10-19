package icc.pap.u1.patrones.creacionales;

public class Email implements Notificacion {
    public void enviar() {
        System.out.println("Notificacion enviada por correo");
    }
}