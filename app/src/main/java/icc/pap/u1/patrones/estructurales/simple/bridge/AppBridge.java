package icc.pap.u1.patrones.estructurales.simple.bridge;

public class AppBridge {
    public static void main(String[] args) {
        Notificacion not1 = new NotificacionAcademica(new CanalCorreo());
        Notificacion not2 = new NotificacionAcademica(new CanalPush());

        Notificacion notSegCorr = new NotificacionAcademica(new CanalCorreo());
        Notificacion notSegPush = new NotificacionAcademica(new CanalPush());

        Notificacion notSeg1 = new NotificacionSeguridad(new CanalCorreo());
        Notificacion notSeg2 = new NotificacionSeguridad(new CanalPush());

        String mensajeAca = "Solicitud #44 aprobada";
        String mensajeSeg = "Alerta de correos Maliciosos";

        not1.notificar(mensajeAca);
        not2.notificar(mensajeAca);

        notSegCorr.notificar(mensajeSeg);
        notSegPush.notificar(mensajeSeg);

        notSeg1.notificar(mensajeAca);
        notSeg2.notificar(mensajeAca);
        
        notSeg1.notificar(mensajeSeg);
        notSeg2.notificar(mensajeSeg);
    }
}
