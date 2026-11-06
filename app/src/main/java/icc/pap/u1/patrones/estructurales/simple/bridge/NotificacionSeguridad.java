package icc.pap.u1.patrones.estructurales.simple.bridge;

public class NotificacionSeguridad extends Notificacion {
    public NotificacionSeguridad(CanalEnvio canalEnvio) {
        super(canalEnvio);
    }

    @Override
    public void notificar(String mensaje) {
        canal.enviar("No seguro: " + mensaje);
    }
}
