package icc.pap.u1.patrones.comportamiento.state2;



public interface EstadoPedido {
    public void pagar(Pedido pedido);
    public void enviar(Pedido pedido);
    public void entregar(Pedido pedido);
    public void cancelar(Pedido pedido);

    public String nombre();
}