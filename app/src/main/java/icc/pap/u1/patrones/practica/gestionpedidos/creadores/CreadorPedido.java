package icc.pap.u1.patrones.practica.gestionpedidos.creadores;

import icc.pap.u1.patrones.practica.gestionpedidos.pedidos.Pedido;

public abstract class CreadorPedido {

    public abstract Pedido crearPedido(String codigo, String cliente, double subtotal);
}


