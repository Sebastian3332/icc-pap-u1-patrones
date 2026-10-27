package icc.pap.u1.patrones.practica.gestionpedidos.pedidos;

import icc.pap.u1.patrones.practica.gestionpedidos.configuracion.ConfiguracionSistema;

public abstract class Pedido {

    protected String codigo;
    protected String cliente;
    protected double subtotal;

    public Pedido(String codigo, String cliente, double subtotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.subtotal = subtotal;
    }

    public void procesar() {

        double impuesto = subtotal * ConfiguracionSistema.getInstancia().getImpuesto() / 100;

        double total = subtotal + impuesto;

        System.out.println("Codigo: " + codigo);
        System.out.println("Cliente: " + cliente);
        System.out.printf(java.util.Locale.US,"Subtotal: $%.2f%n", subtotal);
        System.out.printf(java.util.Locale.US,"Impuesto: $%.2f%n", impuesto);
        System.out.printf(java.util.Locale.US,"Total: $%.2f%n", total);

        generarComprobante();
    }

    public abstract void generarComprobante();
}

