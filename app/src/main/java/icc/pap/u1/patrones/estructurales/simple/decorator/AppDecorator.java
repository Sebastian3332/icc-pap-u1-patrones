package icc.pap.u1.patrones.estructurales.simple.decorator;

public class AppDecorator {
    public static void main(String[] args) {

 
        Bebida cafe = new CafeSimple();
        System.out.println(cafe.descripcion() + " $" + cafe.precio());

        
        Bebida cafeConLeche = new Leche(cafe);
        System.out.println(cafeConLeche.descripcion() + " $" + cafeConLeche.precio());

    
        Bebida cafeConLeche2 = new Leche(new CafeSimple());
        System.out.println(cafeConLeche2.descripcion() + " $" + cafeConLeche2.precio());

        Bebida cafeConChocolate = new Chocolate(new CafeSimple());
        System.out.println(cafeConChocolate.descripcion() + " $" + cafeConChocolate.precio());

        Bebida cafeConLecheYChocolate = new Chocolate(cafeConLeche);
        System.out.println(cafeConLecheYChocolate.descripcion() + " $" + cafeConLecheYChocolate.precio());

  
        Bebida cafeConChocolateYLeche = new Leche(cafeConChocolate);
        System.out.println(cafeConChocolateYLeche.descripcion() + " $" + cafeConChocolateYLeche.precio());

  
        Bebida cafeChocolateChocola1 = new Chocolate(cafeConChocolate);
        Bebida cafeChocolateChocola2 = new Leche(cafeChocolateChocola1);
        System.out.println(cafeChocolateChocola2.descripcion() + " $" + cafeChocolateChocola2.precio());
    }
}
