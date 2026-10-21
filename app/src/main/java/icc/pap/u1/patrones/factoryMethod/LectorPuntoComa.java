package icc.pap.u1.patrones.factoryMethod;
public class LectorPuntoComa implements LectorLinea{
    @Override
    public Lector leerLinea(String linea) {
        String[] partes = linea.split(";");
       
        return new Lector(partes[0], Double.parseDouble(partes[1]), partes[2]);
    }


}