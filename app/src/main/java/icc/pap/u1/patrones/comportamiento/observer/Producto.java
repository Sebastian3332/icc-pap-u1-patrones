
package icc.pap.u1.patrones.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Producto {

    public final List<Consumer<CambioProducto>> observadores;

    private String codigo;
    private double precio;
    private String nombre;


    public Producto(String codigo, double precio, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.observadores = new ArrayList<>();
    }

    public void suscribir(Consumer<CambioProducto> observador) {
        observadores.add(observador);

    }

    private void notifyAll(CambioProducto p) {
        for (Consumer<CambioProducto> observador : observadores) {
            observador.accept(p);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String codigoAnt = this.codigo;
        this.codigo = codigo;
        CambioProducto cambio = new CambioProducto(this, "codigo", codigoAnt, codigo);
        notifyAll(cambio);
    }

    public double getPrecio() {
        return precio;

    }

    public void setPrecio(double precio) {
        double precioAnt = this.precio;
        this.precio = precio;
        CambioProducto cambio = new CambioProducto(this, "precio", precioAnt, precio);
        notifyAll(cambio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String nombreAnt = this.nombre;
        this.nombre = nombre;
        CambioProducto cambio = new CambioProducto(this, "nombre", nombreAnt, nombre);
        notifyAll(cambio);
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + "]";
    }

}