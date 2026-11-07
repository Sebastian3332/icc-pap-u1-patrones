
package icc.pap.u1.patrones.estructurales.practica2;

public class AppNotificaciones {

    public static void main(String[] args) {

        CanalEnvio canalSMS = new CanalSMS();
        CanalEnvio canalCorreo = new CanalCorreo();
        CanalEnvio canalPush = new CanalPush();

        // CASO 1: Notificacion academica por correo
        System.out.println("CASO 1 ");
        Notificacion academica = new NotificacionAcademica(canalCorreo);
        academica.notificar("estudiante@universidad.edu", "Tus calificaciones estan disponibles.");

        // CASO 2: Notificacion administrativa por SMS
        System.out.println("CASO 2 ");
        Notificacion administrativa = new NotificacionAdministrativa(canalSMS);
        administrativa.notificar("0991234567", "Existe un tramite pendiente.");

        // CASO 3: Notificacion de seguridad con autorizacion
        System.out.println("CASO 3 ");
        CanalEnvio proxyPush = new ProxyCanalEnvio(canalPush, true);
        Notificacion seguridad = new NotificacionSeguridad(proxyPush);
        seguridad.notificar("usuario123", "Se ha detectado una alerta de seguridad.");

        // CASO 4: Notificacion academica sin autorizacion
        System.out.println("CASO 4 ");
        CanalEnvio proxySMS = new ProxyCanalEnvio(canalSMS, false);
        Notificacion academicaBloqueada = new NotificacionAcademica(proxySMS);
        academicaBloqueada.notificar("0987654321", "Tus calificaciones estan disponibles.");

        // CASO 5: Reutilizar el mismo canal de correo
        System.out.println("CASO 5 ");
        Notificacion academicaCorreo = new NotificacionAcademica(canalCorreo);
        Notificacion administrativaCorreo = new NotificacionAdministrativa(canalCorreo);
        academicaCorreo.notificar("estudiante@universidad.edu", "Ya puedes revisar tus notas.");
        administrativaCorreo.notificar("docente@universidad.edu", "Existe un tramite administrativo.");

        // CASO 6: Bridge y Proxy con diferentes canales
        System.out.println("CASO 6 ");
        CanalEnvio proxyCorreo = new ProxyCanalEnvio(canalCorreo, true);
        CanalEnvio proxySMSBloqueado = new ProxyCanalEnvio(canalSMS, false);
        Notificacion seguridadCorreo = new NotificacionSeguridad(proxyCorreo);
        Notificacion seguridadSMS = new NotificacionSeguridad(proxySMSBloqueado);
        seguridadCorreo.notificar("estudiante@universidad.edu", "Alerta de seguridad institucional.");

        seguridadSMS.notificar("0991234567", "Alerta de seguridad institucional.");
    }
}

