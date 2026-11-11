package icc.pap.u1.patrones.comportamiento.observer;

public record CambioProducto (
    Producto producto,
    String atributo,
    Object anterior,
    Object nuevo
) {
}
