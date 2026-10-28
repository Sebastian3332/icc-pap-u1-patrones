package icc.pap.u1.patrones.estructurales.simple.decorator;

public final class Chocolate implements Bebida{

    protected final Bebida bebida;

    public Chocolate(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String descripcion() {
        return bebida.descripcion() + " con chocolate";
    }

    @Override
    public double precio() {
        return bebida.precio() + 0.75;
    }
    
    
    
}
