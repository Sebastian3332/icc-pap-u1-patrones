package icc.pap.u1.patrones.estructurales.simple.bridge;

public class CanalSeguridad implements CanalEnvio {

    @Override 
    public void enviar(String mensaje) {
        System.out.println("Seguridad: " + mensaje);
    }
    
}
