package icc.pap.u1.patrones.comportamiento.observer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        if (Objects.equals(this.codigo, codigo)) return;
        String codigoAnt = this.codigo;
        this.codigo = codigo;
        notificar(new CambioEstudiante(this, "codigo", codigoAnt, codigo));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (Objects.equals(this.nombre, nombre)) return;
        String nombreAnt = this.nombre;
        this.nombre = nombre;
        notificar(new CambioEstudiante(this, "nombre", nombreAnt, nombre));
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (Double.compare(this.promedio, promedio) == 0) return;
        double promedioAnt = this.promedio;
        this.promedio = promedio;
        notificar(new CambioEstudiante(this, "promedio", promedioAnt, promedio));
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        if (this.asistencias == asistencias) return;
        int asistenciasAnt = this.asistencias;
        this.asistencias = asistencias;
        notificar(new CambioEstudiante(this, "asistencias", asistenciasAnt, asistencias));
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        if (this.matricula == matricula) return;
        Matricula matriculaAnt = this.matricula;
        this.matricula = matricula;
        notificar(new CambioEstudiante(this, "matricula", matriculaAnt, matricula));
    }

    public void suscribir(Consumer<CambioEstudiante> observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void desuscribir(Consumer<CambioEstudiante> observador) {
        observadores.remove(observador);
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