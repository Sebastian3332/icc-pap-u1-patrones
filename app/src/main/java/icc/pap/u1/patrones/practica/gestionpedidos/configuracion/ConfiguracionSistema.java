package icc.pap.u1.patrones.practica.gestionpedidos.configuracion;

public class ConfiguracionSistema {

    private static ConfiguracionSistema instancia;
    private double impuesto;

    private ConfiguracionSistema() {
        impuesto = 15.0;
    }

    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

   
}
