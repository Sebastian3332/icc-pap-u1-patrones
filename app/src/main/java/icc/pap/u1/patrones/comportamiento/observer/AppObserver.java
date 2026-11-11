
package icc.pap.u1.patrones.comportamiento.observer;

public class AppObserver {

    public static void main(String[] args) {

        Producto p = new Producto("001", 20.05, "Pizza");

        p.suscribir(cP -> System.out.println("Correo: " + cP));

        p.suscribir(cP -> System.out.println("Registro: " + cP));
        //String codOld = p.getCodigo();
           //p.suscribir(producto -> {

           // if (codOld != producto.getCodigo()) {

         //       System.out.printf("El codigo viejo es %s, y el nuevo es %s%n", codOld, producto.getCodigo());
        //    }

        //}

        p.suscribir(cP -> {
            System.out.println("Se modifico el " + cP.atributo());
            System.out.println("Old=" + cP.anterior() + "| New =" + cP.nuevo());
        });

        // Cambiamos el precio y notificamos automáticamente
        p.setPrecio(15.50);
        p.setNombre("PIZZA");
        p.setCodigo("004");

    }
}