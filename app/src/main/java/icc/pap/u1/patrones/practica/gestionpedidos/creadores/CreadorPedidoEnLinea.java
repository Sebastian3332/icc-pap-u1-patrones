package icc.pap.u1.patrones.practica.gestionpedidos.creadores;

import icc.pap.u1.patrones.practica.gestionpedidos.pedidos.Pedido;
import icc.pap.u1.patrones.practica.gestionpedidos.pedidos.PedidoEnLinea;

public class CreadorPedidoEnLinea extends CreadorPedido {

    @Override
    public Pedido crearPedido(String codigo, String cliente, double subtotal) {
        
        return new PedidoEnLinea(codigo, cliente, subtotal);
    }
}
