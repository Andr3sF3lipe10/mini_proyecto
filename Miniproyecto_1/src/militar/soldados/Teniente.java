package militar.soldados;

import militar.operaciones.OperacionesMilitares;
import militar.rangos.Rango;

public class Teniente extends Rango implements OperacionesMilitares {
    private final String unidad;
    private String misionAsignada;

    public Teniente(String nombre, String id, String unidad) {
        super(nombre, id, 2); // Nivel 2 para Teniente
        this.rango = "Teniente";
        this.unidad = unidad;
    }

    @Override
    public String realizarAccion() {
        return nombre + " está supervisando la unidad " + unidad +
                " en la misión: " + misionAsignada;
    }

    @Override
    public String asignarMision(String mision) {
        this.misionAsignada = mision;
        return "Teniente " + nombre + " ha recibido la misión: " + mision;
    }

    @Override
    public void reportarEstado() {
        System.out.println("Teniente " + nombre + " reporta: Unidad " + unidad +
                " lista para la misión.");
    }

    @Override
    public void prepararseParaMision() {
        System.out.println("Teniente " + nombre + " está revisando el plan de la misión.");
    }

    public String getUnidad() {
        return unidad;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }
}
