package militar.soldados;

import militar.rangos.Rango;

/**
 * Clase que representa a un Coronel.
 */
public class Coronel extends Rango {

    private final String estrategia;
    private String misionAsignada;

    public Coronel(String nombre, String id, String estrategia) {
        super(nombre, id, 4); // Nivel 4 para Coronel
        this.rango = "Coronel";
        this.estrategia = estrategia;
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " está implementando la estrategia: " + estrategia +
                " para la misión: " + misionAsignada;
    }

    @Override
    public String asignarMision(String mision) {
        this.misionAsignada = mision;
        return "Coronel " + getNombre() + " ha recibido la misión: " + mision;
    }

    @Override
    public void reportarEstado() {
        System.out.println("Coronel " + getNombre() + " reporta: Estrategia " + estrategia +
                " en ejecución para la misión " + misionAsignada + ".");
    }

    // Métodos Getter
    public String getEstrategia() {
        return estrategia;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }
}
