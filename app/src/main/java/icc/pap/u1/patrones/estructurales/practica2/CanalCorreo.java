package icc.pap.u1.patrones.estructurales.practica2;

public class CanalCorreo implements CanalEnvio {

    @Override 
    public void enviar(String mensaje) {
        System.out.println("Correo: " + mensaje);
    }
    
}
