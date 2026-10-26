package icc.pap.u1.patrones.creacionales.BuilderMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Obj Builder
// Pizza Builder acumula las opciones de una pizza
// y creara un producto(Objeto(Pizza)) cuando se pida 
// al metodo construir

public final class PizzaBuilder {

    private String size = "mediana";
    private List<String> ingredientes = new ArrayList<>();

    
    // Vacio default
    public PizzaBuilder() {
        this.size = "mediana";
        this.ingredientes = new ArrayList<>();
        this.ingredientes.add("Queso");
    }

    // OPC1
    public PizzaBuilder size(String size) {
        this.size = size;
        return this;
    }
    
    //OPC2

    public PizzaBuilder addIng(String ing) {
        boolean contiene = ingredientes.contains(ing);
        if(contiene){
            return this;
        }
        this.ingredientes.add(ing);
        return this;
    }

    // Metodo Build
    // devuelve el producto
    public Pizza build() {
        return new Pizza(size, ingredientes);
    }
}
