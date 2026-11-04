package icc.pap.u1.patrones.estructurales.simple.facade;
// facade es la que cordina los componentes necesarios

public class CineEnCasa {

    private final Proyector proyector;
    private final Reproductor reproductor;


    public CineEnCasa() {
        this.proyector = new Proyector();
        this.reproductor = new Reproductor();
    }

    public void iniciarPelicula(String nombre) {
        proyector.encender();
        reproductor.reproducir(nombre);
    }

    
}
