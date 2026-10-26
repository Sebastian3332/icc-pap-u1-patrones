package icc.pap.u1.patrones.creacionales.BuilderMethod;

import java.util.List;

public final class Pizza {
    private final String size;
    private final List<String> ingredientes;

    protected Pizza(String size, List<String> ingredientes) {
        this.size = size;
        this.ingredientes = ingredientes;
    }

    public String descripcion() {
        return "Pizza " + size + " con: " + ingredientes;
    }
    

    
}
