package militar.soldados;

import militar.rangos.Rango;

/**
 * Clase que representa a un Teniente.
 */
public class Teniente extends Rango {

    private final String unidad;
    private String misionAsignada;

    public Teniente(String nombre, String id, String unidad) {
        super(nombre, id, 2); // Nivel 2 para Teniente
        this.rango = "Teniente";
        this.unidad = unidad;
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " está supervisando la unidad " + unidad +
                " en la misión: " + misionAsignada;
    }

    @Override
    public String asignarMision(String mision) {
        this.misionAsignada = mision;
        return "Teniente " + getNombre() + " ha recibido la misión: " + mision;
    }

    @Override
    public void reportarEstado() {
        System.out.println("Teniente " + getNombre() + " reporta: Unidad " + unidad +
                " lista para la misión.");
    }

    @Override
    public void prepararseParaMision() {
        System.out.println("Teniente " + getNombre() + " está revisando el plan de la misión.");
    }

    // Métodos Getter
    public String getUnidad() {
        return unidad;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }
}
