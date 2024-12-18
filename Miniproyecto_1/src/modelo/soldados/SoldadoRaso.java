package modelo.soldados;

import modelo.rangos.Rango;

/**
 * Clase que representa a un Soldado Raso.
 */
public class SoldadoRaso extends Rango {

    private String misionAsignada;

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id, 1); // Nivel 1 para Soldado Raso
        this.rango = "Soldado Raso";
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " está siguiendo órdenes en la misión: " + misionAsignada;
    }

    @Override
    public String asignarMision(String mision) {
        this.misionAsignada = mision;
        return "Soldado Raso " + getNombre() + " ha recibido la misión: " + mision;
    }

    @Override
    public void reportarEstado() {
        System.out.println("Soldado Raso " + getNombre() + " reporta: En posición y listo para la misión.");
    }

    // Método Getter
    public String getMisionAsignada() {
        return misionAsignada;
    }
}
