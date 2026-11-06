package icc.pap.u1.patrones.estructurales.practica2;

public abstract class Notificacion {
    
    protected final CanalEnvio canal;

    // Constructor

    public Notificacion(CanalEnvio canal) {
        this.canal = canal;
    }

    public abstract void notificar(String mensaje);
    
}