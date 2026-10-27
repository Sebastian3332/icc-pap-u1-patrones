package icc.pap.u1.patrones;

import java.util.List;

import icc.pap.u1.patrones.creacionales.FactoryDemo;
import icc.pap.u1.patrones.creacionales.Notificacion;
import icc.pap.u1.patrones.creacionales.BuilderMethod.Pizza;
import icc.pap.u1.patrones.creacionales.BuilderMethod.PizzaBuilder;
import icc.pap.u1.patrones.creacionales.prototype.PlantillaEmail;
import icc.pap.u1.patrones.factoryMethod.Importador;
import icc.pap.u1.patrones.factoryMethod.ImportadorPuntoComa;
import icc.pap.u1.patrones.factoryMethod.ImportadorTabulacion;
import icc.pap.u1.patrones.practica.gestionpedidos.configuracion.ConfiguracionSistema;
import icc.pap.u1.patrones.practica.gestionpedidos.creadores.CreadorPedido;
import icc.pap.u1.patrones.practica.gestionpedidos.creadores.CreadorPedidoEnLinea;
import icc.pap.u1.patrones.practica.gestionpedidos.creadores.CreadorPedidoPresencial;
import icc.pap.u1.patrones.practica.gestionpedidos.pedidos.Pedido;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        FactoryDemo fabrica = new FactoryDemo();

        Notificacion notificacion1 = fabrica.crearNotificacion("email");
        Notificacion notificacion2 = fabrica.crearNotificacion("sms");

        if (notificacion1 != null) {
            notificacion1.enviar();
        }

        if (notificacion2 != null) {
            notificacion2.enviar();
        }

        runFactoryMethod();
        // runPrototype();
        // runBuilder();
        runPractica();
    }

    private static void runFactoryMethod() {
        Importador impPC = new ImportadorPuntoComa();
        System.out.println(impPC.importacion(List.of("SO1;22.5;C","SO2;18;C")));
        Importador impTab = new ImportadorTabulacion();
        System.out.println(impTab.importacion(List.of("SO1\t22.5\tC","SO2\t18\tC")));
    }

    private static void runPrototype() {
        PlantillaEmail pEmail = new PlantillaEmail("Aviso", "Pedido Listo");

        PlantillaEmail pEmailSolicitud = pEmail.clone();

        pEmailSolicitud.cambiarAsunto("Solicitud");

        System.out.println(pEmail);
        System.out.println(pEmailSolicitud.contenido());
    }

    private static void runBuilder() {

        Pizza pizza = new PizzaBuilder().addIng("Jamon").size("Large").addIng("Salami").build();

        Pizza pizza2 = new PizzaBuilder().build();

        System.out.println(pizza.descripcion());
        System.out.println(pizza2.descripcion());
    }

    private static void runPractica() {

        ConfiguracionSistema configuracion1 = ConfiguracionSistema.getInstancia();

        ConfiguracionSistema configuracion2 = ConfiguracionSistema.getInstancia();

        System.out.println("Configuracion del sistema");
        System.out.printf(java.util.Locale.US, "Impuesto: %.1f%%%n", configuracion1.getImpuesto());

        System.out.println();

        CreadorPedido creadorPresencial = new CreadorPedidoPresencial();

        Pedido pedido1 = creadorPresencial.crearPedido("P001", "Ana Torres", 100.00);

        System.out.println("--- Pedido presencial ---"); 
        pedido1.procesar();

        System.out.println();

        CreadorPedido creadorEnLinea = new CreadorPedidoEnLinea();

        Pedido pedido2 = creadorEnLinea.crearPedido("P002", "Juan Perez", 200.00);

        System.out.println("--- Pedido en linea ---");
        pedido2.procesar();

        System.out.println();

        System.out.println("Configuracion compartida: " + (configuracion1 == configuracion2));




    }


}