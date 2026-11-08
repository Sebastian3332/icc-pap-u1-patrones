
package icc.pap.u1.patrones.estructurales.simple.adapter;

public class AppAdapter {

    public static void main(String[] args) {

        CargadorAntiguo cAntiguo = new CargadorAntiguo();
        CargadorInalambrico cInalambrico = new CargadorInalambrico();

        Cargador cUsb = new AdaptadorCargador(cAntiguo);
        Cargador cInal = new AdaptadorCargadorIna(cInalambrico);

        // Caso 1: Cargador antiguo con registro
        Cargador c1 = new DecoradorRegistro(cUsb);

        // Caso 2: Cargador inalambrico con seguridad permitida
        Cargador c2 = new DecoradorSeguridad(cInal, true);

        // Caso 3: Cargador antiguo con seguridad bloqueada
        Cargador c3 = new DecoradorSeguridad(cUsb, false);

        // Caso 4: Cargador inalambrico con dos decoradores
        Cargador c4 = new DecoradorSeguridad(new DecoradorRegistro(cInal), true);

        System.out.println("CASO 1");
        c1.cargarCelular();

        System.out.println("CASO 2");
        c2.cargarCelular();

        System.out.println("CASO 3");
        c3.cargarCelular();

        System.out.println("CASO 4");
        c4.cargarCelular();
    }
}
