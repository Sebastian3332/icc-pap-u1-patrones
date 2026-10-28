package icc.pap.u1.patrones.estructurales.simple.adapter;

public class AppAdapter {

    public static void main(String[] args) {
        CargadorAntiguo cAntiguo = new CargadorAntiguo();
        Cargador cUsb = new AdaptadorCargador(cAntiguo);

        CargadorInalambrico cInalambrico = new CargadorInalambrico();
        Cargador cInal = new AdaptadorCargadorIna(cInalambrico);
        cUsb.cargarCelular();
        cInal.cargarCelular();
    }
}
