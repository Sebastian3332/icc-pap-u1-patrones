package icc.pap.u1.patrones.estructurales.practica2;

public class CanalSMS implements CanalEnvio {

    @Override 
    public void enviar(String mensaje) {
        System.out.println("SMS: " + mensaje);
    }
}
