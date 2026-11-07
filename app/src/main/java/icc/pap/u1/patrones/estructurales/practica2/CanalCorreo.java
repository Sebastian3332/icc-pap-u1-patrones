package icc.pap.u1.patrones.estructurales.practica2;

public class CanalCorreo implements CanalEnvio {

    @Override 
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Correo a " + destinatario + ", " + mensaje);
    }
    
}
