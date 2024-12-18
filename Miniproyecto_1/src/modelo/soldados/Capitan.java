package modelo.soldados;

import modelo.rangos.Rango;

/**
 * Clase que representa a un Capitán.
 */
public class Capitan extends Rango {

    private final int cantidadSoldadosBajoSuMando;
    private String misionAsignada;

    public Capitan(String nombre, String id, int cantidadSoldadosBajoSuMando) {
        super(nombre, id, 3); // Nivel 3 para Capitán
        this.rango = "Capitán";
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " está coordinando la misión: " + misionAsignada +
                " con " + cantidadSoldadosBajoSuMando + " soldados.";
    }

    @Override
    public String asignarMision(String mision) {
        this.misionAsignada = mision;
        return "Capitán " + getNombre() + " ha recibido la misión: " + mision;
    }

    @Override
    public void reportarEstado() {
        System.out.println("Capitán " + getNombre() + " reporta: Preparado para coordinar " +
                misionAsignada + " con " + cantidadSoldadosBajoSuMando + " soldados.");
    }

    @Override
    public void prepararseParaMision() {
        System.out.println("Capitán " + getNombre() + " está revisando el plan de la misión.");
    }

    // Métodos Getter
    public int getCantidadSoldadosBajoSuMando() {
        return cantidadSoldadosBajoSuMando;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }
}
