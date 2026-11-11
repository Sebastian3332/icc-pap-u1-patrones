package icc.pap.u1.patrones.comportamiento.observer2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Estudiante {
    private String codigo;
    private String nombre;
    private double promedio;
    private int asistencias;
    private Matricula matricula;
    private final List<Consumer<CambioEstudiante>> observadores;

    public Estudiante(String codigo, String nombre, double promedio, int asistencias, Matricula matricula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.asistencias = asistencias;
        this.matricula = matricula;
        this.observadores = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String codigoAnt = this.codigo;
        this.codigo = codigo;
        CambioEstudiante cambio = new CambioEstudiante(this, "codigo", codigoAnt, codigo);
        notificar(cambio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String nombreAnt = this.nombre;
        this.nombre = nombre;
        CambioEstudiante cambio = new CambioEstudiante(this, "nombre", nombreAnt, nombre);
        notificar(cambio);
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        double promedioAnt = this.promedio;
        this.promedio = promedio;
        CambioEstudiante cambio = new CambioEstudiante(this, "promedio", Double.toString(promedioAnt),
                Double.toString(promedio));
        notificar(cambio);
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        String asistenciasAnt = Integer.toString(this.asistencias);
        this.asistencias = asistencias;
        CambioEstudiante cambio = new CambioEstudiante(this, "asistencias", asistenciasAnt,
                Integer.toString(asistencias));
        notificar(cambio);
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        Matricula matriculaAnt = this.matricula;
        this.matricula = matricula;
        CambioEstudiante cambio = new CambioEstudiante(this, "matricula", matriculaAnt, matricula);
        notificar(cambio);
    }

    public void suscribir(Consumer<CambioEstudiante> observador) {
        observadores.add(observador);
    }

    public void notificar(CambioEstudiante p) {
        for (Consumer<CambioEstudiante> observador : observadores) {
            observador.accept(p);
        }
    }

    @Override
    public String toString() {
        return "Estudiante [codigo=" + codigo + ", nombre=" + nombre + ", promedio=" + promedio + ", asistencias="
                + asistencias + ", matricula=" + matricula + "]";
    }

}