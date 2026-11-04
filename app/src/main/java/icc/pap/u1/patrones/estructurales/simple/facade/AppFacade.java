package icc.pap.u1.patrones.estructurales.simple.facade;

public class AppFacade {
    public static void main(String[] args) {
        CineEnCasa cine = new CineEnCasa();

        cine.iniciarPelicula("Proyecto x");
        System.out.println("Termino la peli");
    }
    
}
