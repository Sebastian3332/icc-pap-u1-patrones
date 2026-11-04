package icc.pap.u1.patrones.estructurales.simple.composite;

public class AppComposite {
    public static void main(String[] args) {
        
    GrupoMenu combo = new GrupoMenu();

    GrupoMenu hamburguesa = new GrupoMenu();
    hamburguesa.addItem(new ProductoMenu("Queso", 0.5));
    hamburguesa.addItem(new ProductoMenu("Carne", 1.00));
    hamburguesa.addItem(new ProductoMenu("Pan", 0.5));
    hamburguesa.addItem(new ProductoMenu("Lechuga", 0.25));

    ProductoMenu bebida = new ProductoMenu("CocaCola", 1.35);

    combo.addItem(hamburguesa); // AGREGUE un GM (hamburguesa)
    combo.addItem(bebida);      // AGREGUE un PM (bebida)

    System.out.println("combo " + "$" + combo.precio());
    

 

    }
    
}
