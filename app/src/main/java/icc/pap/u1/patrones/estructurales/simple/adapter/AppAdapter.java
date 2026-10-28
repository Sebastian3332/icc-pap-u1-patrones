package icc.pap.u1.patrones.estructurales.simple.adapter;

public class AppAdapter {

    public static void main(String[] args) {

        // CArgar mi celular con un cargador 
        // Pero como tengo un cargadior antiguo debo crear adaptador
        CargadorAntiguo cAntiguo = new CargadorAntiguo();
        Cargador cargor1 = new AdaptadorCargador(cAntiguo);

        CargadorInalambrico cInalambrico = new CargadorInalambrico();
        Cargador cargor2 = new AdaptadorCargadorIna(cInalambrico);

        cargor1.cargarCelular();
        cargor2.cargarCelular();

        cInalambrico.cargarBase();
    }
    
}
