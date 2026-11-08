package icc.pap.u1.patrones.estructurales.simple.adapter;

public class DecoradorCargador implements Cargador {

    protected Cargador cargador;

    public DecoradorCargador(Cargador cargador) {
        this.cargador = cargador;
    }

    @Override 
    public void cargarCelular() {
        cargador.cargarCelular();
    }


}