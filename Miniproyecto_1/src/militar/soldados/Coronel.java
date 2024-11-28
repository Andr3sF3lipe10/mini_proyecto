package militar.soldados;

import militar.operaciones.OperacionesMilitares;
import militar.rangos.Rango;

public class Coronel extends Rango implements OperacionesMilitares {
    private final String estrategia;
    private String misionAsignada;

    public Coronel(String nombre, String id, String estrategia) {
        super(nombre, id, 4); // Nivel 4 para Coronel
        this.rango = "Coronel";
        this.estrategia = estrategia;
    }

    @Override
    public String realizarAccion() {
        return nombre + " está implementando la estrategia: " + estrategia +
                " para la misión: " + misionAsignada;
    }

    @Override
    public String asignarMision(String mision) {
        this.misionAsignada = mision;
        return "Coronel " + nombre + " ha recibido la misión: " + mision;
    }

    @Override
    public void reportarEstado() {
        System.out.println("Coronel " + nombre + " reporta: Estrategia " + estrategia +
                " en ejecución para la misión " + misionAsignada + ".");
    }

    public String getEstrategia() {
        return estrategia;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }
}
