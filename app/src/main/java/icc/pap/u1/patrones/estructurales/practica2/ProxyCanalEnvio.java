package icc.pap.u1.patrones.estructurales.practica2;

public class ProxyCanalEnvio implements CanalEnvio {

    private final CanalEnvio canalReal;
    private final boolean autorizado;

    public ProxyCanalEnvio(CanalEnvio canalReal, boolean autorizado) {
        this.canalReal = canalReal;
        this.autorizado = autorizado;
    }

    @Override 
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Veridicando autorizacion");
        if(autorizado) {
            canalReal.enviar(destinatario, mensaje);
        } else {
            System.out.println("Envio bloqueado usuario no autorizado");
        }
    }

    
    
}
