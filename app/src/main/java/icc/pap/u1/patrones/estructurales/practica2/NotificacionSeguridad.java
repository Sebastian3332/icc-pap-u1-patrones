package icc.pap.u1.patrones.estructurales.practica2;

public class NotificacionSeguridad extends Notificacion {
    
    public NotificacionSeguridad(CanalEnvio canalEnvio) {
        super(canalEnvio);
    }

    @Override
    public void notificar(String mensaje) {
        canal.enviar("Seguridad" + mensaje);
    }
}
