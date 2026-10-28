package icc.pap.u1.patrones.estructurales.simple.adapter;

public class AdaptadorCargador implements Cargador {

    private final CargadorAntiguo cargadorAntiguo;

    public AdaptadorCargador(CargadorAntiguo cargadorAntiguo) {
        this.cargadorAntiguo = new CargadorAntiguo();
    }
    
    @Override
    public void cargarCelular() {
        cargadorAntiguo.cargarConector();
    }
}
