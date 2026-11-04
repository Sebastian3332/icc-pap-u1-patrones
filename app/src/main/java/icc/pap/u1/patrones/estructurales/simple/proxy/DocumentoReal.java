package icc.pap.u1.patrones.estructurales.simple.proxy;

public class DocumentoReal implements Documento {
    private final String path;

    public DocumentoReal(String path) {
        this.path = path;
        System.out.println("Cargando documento desde: " + path);
    }

    @Override 
    public void mostrar() {
        System.out.println("Mostrar documento desde: " + path);
    }

    
}
