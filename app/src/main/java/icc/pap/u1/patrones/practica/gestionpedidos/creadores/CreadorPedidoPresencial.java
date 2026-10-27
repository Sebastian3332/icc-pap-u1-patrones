package icc.pap.u1.patrones.practica.gestionpedidos.creadores;

import icc.pap.u1.patrones.practica.gestionpedidos.pedidos.Pedido;
import icc.pap.u1.patrones.practica.gestionpedidos.pedidos.PedidoPresencial;

public class CreadorPedidoPresencial extends CreadorPedido {

    @Override
    public Pedido crearPedido(String codigo, String cliente, double subtotal) {
        
        return new PedidoPresencial(codigo, cliente, subtotal);
    }
}