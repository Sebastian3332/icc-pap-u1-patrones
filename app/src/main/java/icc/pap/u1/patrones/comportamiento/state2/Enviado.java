package icc.pap.u1.patrones.comportamiento.state2;

public class Enviado implements EstadoPedido {

    @Override 
    public void pagar(Pedido pedido){
        System.out.println("Ya esta pagado");

        }

    @Override 
    public void enviar(Pedido pedido){
        System.out.println("Pedido enviado");
                
        }

    @Override 
    public void entregar(Pedido pedido){
        System.out.println("Debe enviarse primero");
        pedido.changeState(new Entregado());
    }

    @Override 
    public void cancelar(Pedido pedido){
        System.out.println("No se puede cancelar un pedido enviado");
    }

    @Override
    public String nombre() {
        return "ENTREGADO";
    }
}
