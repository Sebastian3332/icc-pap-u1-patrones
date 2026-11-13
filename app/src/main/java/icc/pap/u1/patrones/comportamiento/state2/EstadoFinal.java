package icc.pap.u1.patrones.comportamiento.state2;

public abstract class EstadoFinal implements EstadoPedido{

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Operacion no permnitida");
        
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Operacion no permnitida");
        
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Operacion no permnitida");
    }

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Operacion no permnitida");
    }

    


    
}
