package icc.pap.u1.patrones.estructurales.practica2;

public class NotificacionAdministrativa extends Notificacion {
    
    public NotificacionAdministrativa(CanalEnvio canalEnvio) {
        super(canalEnvio);
    }

    @Override
    public void notificar(String destinatario, String mensaje) {
        canal.enviar(destinatario, "Not Administrativa: " + mensaje);
    }
}
